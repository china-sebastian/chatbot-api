package cn.bugstack.ai.api.application.job;

import cn.bugstack.ai.api.domain.ai.IOpenAI;
import cn.bugstack.ai.api.domain.zsxq.IZsxqApi;
import cn.bugstack.ai.api.domain.zsxq.model.aggregates.UnansweredQuestionAggregates;
import cn.bugstack.ai.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 问题任务
 * @Date 2023/5/23 19:46
 * github:https://github.com/china-sebastian
 */
@EnableScheduling
@Configuration
public class ChatbotTask implements Runnable{

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;
private Logger logger = LoggerFactory.getLogger(ChatbotTask.class);
//    private String groupName;
//    private String groupId;
//    private String cookie;
//    private String openAiKey;
//    private boolean silenced;
//
//    private IZsxqApi zsxqApi;
//    private IOpenAI openAI;

//    public ChatbotTask(String groupName, String groupId, String cookie, String openAiKey, IZsxqApi zsxqApi, IOpenAI openAI, boolean silenced) {
//        this.groupName = groupName;
//        this.groupId = groupId;
//        this.cookie = cookie;
//        this.openAiKey = openAiKey;
//        this.zsxqApi = zsxqApi;
//        this.openAI = openAI;
//        this.silenced = silenced;
//    }

    // 表达式：cron.qqe2.com
    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){

        if (new Random().nextBoolean()){
            logger.info("随机打烊中");
            return;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour > 22 ||hour < 7){
            logger.info("打烊时间不工作，下班了!");
            return;
        }

        try {
            // 1. 检索问题
            UnansweredQuestionAggregates unansweredQuestionAggregates = zsxqApi.queryUnansweredQuestionsTopicId(groupId, cookie);
            logger.info("测试结果:{}", JSON.toJSONString(unansweredQuestionAggregates));
            List<Topics> topics = unansweredQuestionAggregates.getRespData().getTopics();
            if (topics == null || topics.isEmpty()) {
                logger.info("本次检索未查找到待回答的问题");
                return;
            }
            // 2. AI回答
            Topics topic = topics.get(0);
            String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());
            // 3.问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(),answer,false);

            logger.info("编号:{} 问题:{} 回答:{} 状态:{}",topic.getTopic_id(),topic.getQuestion().getText(),answer,status);


        }catch (Exception e){
            logger.error("自动回答问题异常:{}",e.getMessage());
        }
    }
}

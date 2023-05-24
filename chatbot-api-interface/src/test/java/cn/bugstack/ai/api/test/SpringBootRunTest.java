package cn.bugstack.ai.api.test;

import cn.bugstack.ai.api.domain.ai.IOpenAI;
import cn.bugstack.ai.api.domain.zsxq.IZsxqApi;
import cn.bugstack.ai.api.domain.zsxq.model.aggregates.UnansweredQuestionAggregates;
import cn.bugstack.ai.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 16:30
 * github:https://github.com/china-sebastian
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger  = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;


    @Value("${chatbot-api.openAiKey}")
    private String openAiKey;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnansweredQuestionAggregates unansweredQuestionAggregates = zsxqApi.queryUnansweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果:{}", JSON.toJSONString(unansweredQuestionAggregates));

        List<Topics> topics = unansweredQuestionAggregates.getRespData().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId:{} text:{}",topicId,text);
            boolean answer = zsxqApi.answer(groupId, cookie, topicId, text, false);
            logger.info("问题回答完成:{}",answer);
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        String respnse = openAI.doChatGPT("帮我写一个Java冒泡排序");
        logger.info("查询结果:{}",respnse);
    }



    @Test
    public void testApi(){

    }
}



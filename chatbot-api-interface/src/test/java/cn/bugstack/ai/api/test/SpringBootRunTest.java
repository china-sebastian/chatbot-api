package cn.bugstack.ai.api.test;

import cn.bugstack.ai.api.domain.zsxq.IZsxqApi;
import cn.bugstack.ai.api.domain.zsxq.model.aggregates.UnansweredQuestionAggregates;
import cn.bugstack.ai.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Resource
    private IZsxqApi zsxqApi;

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



}



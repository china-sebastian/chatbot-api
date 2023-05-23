package cn.bugstack.ai.api.domain.zsxq;

import cn.bugstack.ai.api.domain.zsxq.model.aggregates.UnansweredQuestionAggregates;

import java.io.IOException;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 知识星球API接口
 * @Date 2023/5/23 15:54
 * github:https://github.com/china-sebastian
 */
public interface IZsxqApi {

    UnansweredQuestionAggregates queryUnansweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId,String text, boolean silenced) throws IOException;
}

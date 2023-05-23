package cn.bugstack.ai.api.domain.ai;

import java.io.IOException;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description openAI 接口:https://platform.openai.com/account/api-keys
 * @Date 2023/5/23 19:19
 * github:https://github.com/china-sebastian
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}

package test;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;

import java.util.Arrays;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/24 16:15
 * github:https://github.com/china-sebastian
 */
public class TestApi {
    public static void main(String[] args) {
        OpenAiClient openAiClient = new OpenAiClient("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");
        CompletionResponse completions = openAiClient.completions("写一个Java冒泡排序");
        Arrays.stream(completions.getChoices()).forEach(System.out::println);
    }
}

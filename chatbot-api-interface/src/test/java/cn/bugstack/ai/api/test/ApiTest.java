package cn.bugstack.ai.api.test;


import com.unfbx.chatgpt.OpenAiClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 单元测试
 * @Date 2023/5/23 13:09
 * github:https://github.com/china-sebastian
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String uri = "https://api.zsxq.com/v2/groups/51112115851124/topics?scope=unanswered_questions&count=20";
        System.out.println(uri);
        HttpGet get = new HttpGet(uri);
        String cookie = "__cuid=f777328da6cb492b9b37b3c48498dace; amp_fef1e8=ffc86820-f39e-42d6-893a-ac36705169a0R...1gr812pmt.1gr81gefq.6.1.7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585224152425184%22%2C%22first_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDEwZTdlNGI1ZGUtMGViOTQ2NzFhMzI2ZDctMjYwMzE5NTEtMTc2NDAwMC0xODZkMTBlN2U0Y2UzOSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTIyNDE1MjQyNTE4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585224152425184%22%7D%2C%22%24device_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%7D; zsxq_access_token=7C9F10E0-FC42-9DDF-C1BC-7D646E8BE4F9_0921EDF3A6D1FAA1; abtest_env=product; zsxqsessionid=f4a5fb770052e56d9f92c6df1154f6d3";
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String uri = "https://api.zsxq.com/v2/topics/584412245882854/answer";
        HttpPost post = new HttpPost(uri);
        String cookie = "__cuid=f777328da6cb492b9b37b3c48498dace; amp_fef1e8=ffc86820-f39e-42d6-893a-ac36705169a0R...1gr812pmt.1gr81gefq.6.1.7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585224152425184%22%2C%22first_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDEwZTdlNGI1ZGUtMGViOTQ2NzFhMzI2ZDctMjYwMzE5NTEtMTc2NDAwMC0xODZkMTBlN2U0Y2UzOSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTIyNDE1MjQyNTE4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585224152425184%22%7D%2C%22%24device_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%7D; zsxq_access_token=7C9F10E0-FC42-9DDF-C1BC-7D646E8BE4F9_0921EDF3A6D1FAA1; abtest_env=product; zsxqsessionid=0fd085656b7a6dcb4d993df0203ee383";

        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json; charset=UTF-8");
        String ans = "自己去百度";
//                "以下是Java实现的基本冒泡排序算法```\npublic static void bubbleSort(int[] arr) {\nint n = arr.length;\nfor (int i = 0; i < n - 1; i++) {\n" +
//                "for (int j = 0; j < n - i - 1; j++) {\nif (arr[j] > arr[j + 1]) {\n// 交换相邻两个元素的位置\nint temp = arr[j];\n" +
//                "arr[j] = arr[j + 1];\n arr[j + 1] = temp;\n}\n}\n}\n}\n```\n" +
//                "\n接收一个整型数组作为输入参数，然后依次比较相邻的元素，如果前一个元素比后一个元素大，则将它们的位置交换，这样实现数组中的所有元素按从小到大的顺序排列。\n" +
//                "例如，给定的数组为{3, 5, 2, 4, 1}，根据冒泡排序的实现，排序后的数组为{1, 2, 3, 4, 5}";
//        String paramJson = "{\n" +
//                "  \"req_data\": {\n" +
//                "    \"text\": \""+ans+"\\n\",\n" +
//                "    \"image_ids\": [],\n" +
//                "    \"silenced\": false\n" +
//                "  }\n" +
//                "}";

        String paramJson = "{\n" +
                "    \"req_data\": {\n" +
                "        \"text\": \"冒泡排序是一种简单的排序算法，它重复地比较相邻的两个元素，如果顺序不正确，则交换它们。\\n\\n以下是Java实现冒泡排序的代码示例：\\n\\n```\\npublic class BubbleSort {\\n    public static void bubbleSort(int[] arr) {\\n        int n = arr.length;\\n        int temp = 0;\\n        for (int i = 0; i < n - 1; i++) {\\n            for (int j = 0; j < n - 1 - i; j++) {\\n                if (arr[j] > arr[j + 1]) {\\n                    temp = arr[j];\\n                    arr[j] = arr[j + 1];\\n                    arr[j + 1] = temp;\\n                }\\n            }\\n        }\\n    }\\n\\n    public static void main(String[] args) {\\n        int[] arr = {5, 2, 8, 9, 1};\\n        System.out.println(\\\"before sorting:\\\");\\n        for (int i : arr) {\\n            System.out.print(i + \\\" \\\");\\n        }\\n        System.out.println(\\\"\\\\nafter sorting:\\\");\\n        bubbleSort(arr);\\n        for (int i : arr) {\\n            System.out.print(i + \\\" \\\");\\n        }\\n    }\\n}\\n```\\n\\n运行上述代码，输出结果如下：\\n\\n```\\nbefore sorting:\\n5 2 8 9 1 \\nafter sorting:\\n1 2 5 8 9 \\n```\\n\\n在上述代码中，首先定义一个静态方法`bubbleSort`，它接受一个整数数组作为参数，并根据冒泡排序的算法对数组进行排序。它使用嵌套的for循环，外部循环从数组的第一个元素开始，直到倒数第二个元素，内部循环从数组的第一个元素开始，直到当前外部循环中正在处理的元素的前面一个元素。如果相邻的两个元素的顺序不正确，那么它们将交换位置。\\n\\n然后，我们在`main`方法中定义了一个整数数组，打印未排序的数组，排序后再次打印数组。在Java中，我们可以使用`for-each`循环来遍历数组，从而避免繁琐的索引操作。\",\n" +
                "        \"image_ids\": [],\n" +
                "        \"silenced\": false\n" +
                "    }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT()  {

            try {
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                String chatGPTUri = "https://api.openai.com/v1/models";
                HttpPost httpPost = new HttpPost(chatGPTUri);

                httpPost.addHeader("Content-Type","application/json");
                httpPost.addHeader("Authorization","Bearer  ");




                String paramJson = "{\n" +
                        "     \"model\": \"gpt-3.5-turbo\",\n" +
                        "     \"messages\": [{\"role\": \"user\", \"content\": \"帮我写一个Java冒泡排序\"}],\n" +
                        "     \"temperature\": 0.7\n" +
                        "   }";
                StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
                httpPost.setEntity(stringEntity);

                CloseableHttpResponse response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    String res = EntityUtils.toString(response.getEntity());
                    System.out.println(res);
                } else {
                    System.out.println(response.getStatusLine().getStatusCode());
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }



    
}

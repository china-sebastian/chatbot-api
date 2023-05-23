package cn.bugstack.ai.api.test;


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
        String uri = "https://api.zsxq.com/v2/topics/412241122855118/answer";
        HttpPost post = new HttpPost(uri);
        String cookie = "__cuid=f777328da6cb492b9b37b3c48498dace; amp_fef1e8=ffc86820-f39e-42d6-893a-ac36705169a0R...1gr812pmt.1gr81gefq.6.1.7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585224152425184%22%2C%22first_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDEwZTdlNGI1ZGUtMGViOTQ2NzFhMzI2ZDctMjYwMzE5NTEtMTc2NDAwMC0xODZkMTBlN2U0Y2UzOSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTIyNDE1MjQyNTE4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585224152425184%22%7D%2C%22%24device_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%7D; zsxq_access_token=7C9F10E0-FC42-9DDF-C1BC-7D646E8BE4F9_0921EDF3A6D1FAA1; abtest_env=product; zsxqsessionid=f4a5fb770052e56d9f92c6df1154f6d3";
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


}

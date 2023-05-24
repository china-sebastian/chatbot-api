package cn.bugstack.ai.api.domain.zsxq.service;

import cn.bugstack.ai.api.domain.zsxq.IZsxqApi;
import cn.bugstack.ai.api.domain.zsxq.model.aggregates.UnansweredQuestionAggregates;
import cn.bugstack.ai.api.domain.zsxq.model.req.AnswerReq;
import cn.bugstack.ai.api.domain.zsxq.model.req.Req_data;
import cn.bugstack.ai.api.domain.zsxq.model.resp.AnswerRes;
import cn.hutool.json.ObjectMapper;
import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 16:09
 * github:https://github.com/china-sebastian
 */
@Service
public class ZsxqApi implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);

    @Override
    public UnansweredQuestionAggregates queryUnansweredQuestionsTopicId(String groupId, String cookie) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String uri = "https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=unanswered_questions&count=20";
//        System.out.println(uri);
//        "https://api.zsxq.com/v2/groups/51112115851124/topics?scope=unanswered_questions&count=20";
        HttpGet get = new HttpGet(uri);
        // String cookie = "__cuid=f777328da6cb492b9b37b3c48498dace; amp_fef1e8=ffc86820-f39e-42d6-893a-ac36705169a0R...1gr812pmt.1gr81gefq.6.1.7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585224152425184%22%2C%22first_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDEwZTdlNGI1ZGUtMGViOTQ2NzFhMzI2ZDctMjYwMzE5NTEtMTc2NDAwMC0xODZkMTBlN2U0Y2UzOSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTIyNDE1MjQyNTE4NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585224152425184%22%7D%2C%22%24device_id%22%3A%22186d10e7e4b5de-0eb94671a326d7-26031951-1764000-186d10e7e4ce39%22%7D; zsxq_access_token=7C9F10E0-FC42-9DDF-C1BC-7D646E8BE4F9_0921EDF3A6D1FAA1; abtest_env=product; zsxqsessionid=f4a5fb770052e56d9f92c6df1154f6d3";
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取提问数据。groupId：{} jsonStr：{}", groupId, jsonStr);
            return JSON.parseObject(jsonStr,UnansweredQuestionAggregates.class);
//            return  null;
        } else {
            throw new RuntimeException("queryUnansweredQuestionsTopicId Err Code is " + response.getStatusLine().getStatusCode());
        }

    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId,String text, boolean silenced) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String uri = "https://api.zsxq.com/v2/topics/"+topicId+"/answer";
        HttpPost post = new HttpPost(uri);
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json; charset=UTF-8");
        post.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36");
//        BufferedReader reader = new BufferedReader(new StringReader(text));
//        String line;
//        String newText= "";
//        while((line = reader.readLine())!=null){
//            newText += line;
//        }
//        System.out.println("newText:" + newText);

        String paramJson = "{" +
                "  \"req_data\": {" +
                "    \"text\": \""+ text +"\"," +
                "    \"image_ids\": []," +
                "    \"silenced\": "+silenced+"" +
                "  }" +
                "}";

        paramJson = paramJson.replace("\n","");

        System.out.println(paramJson);
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.APPLICATION_JSON);
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
//            logger.info("回答问题结果。groupId：{} topicId：{} jsonStr：{}", groupId, topicId, jsonStr);

            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
//            System.out.println(answerRes.toString());
            return answerRes.isSucceeded();
        } else {
            throw new RuntimeException("answer Err Code is " + response.getStatusLine().getStatusCode());
        }

    }
}

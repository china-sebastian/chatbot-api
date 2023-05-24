package cn.bugstack.ai.api.domain.zsxq.model.resp;

import java.util.*;
/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 请求问答的结果信息
 * @Date 2023/5/23 16:18
 * github:https://github.com/china-sebastian
 */
public class AnswerRes {

    private boolean succeeded;

    private String code;

    private String info;

    private List<RespData> resp_data;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setInfo(String info){
        this.info = info;
    }
    public String getInfo(){
        return this.info;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public List<RespData> getResp_data() {
        return resp_data;
    }

    public void setResp_data(List<RespData> resp_data) {
        this.resp_data = resp_data;
    }

    @Override
    public String toString() {
        return "AnswerRes{" +
                "succeeded=" + succeeded +
                ", code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", resp_data=" + resp_data +
                '}';
    }
}

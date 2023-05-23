package cn.bugstack.ai.api.domain.zsxq.model.req;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 16:17
 * github:https://github.com/china-sebastian
 */
public class AnswerReq {
    private Req_data req_data;

    public AnswerReq(Req_data req_data) {
        this.req_data = req_data;
    }

    public Req_data getReqData() {
        return req_data;
    }

    public void setReqData(Req_data reqData) {
        this.req_data = reqData;
    }
}

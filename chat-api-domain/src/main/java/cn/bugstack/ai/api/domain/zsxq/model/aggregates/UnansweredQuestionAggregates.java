package cn.bugstack.ai.api.domain.zsxq.model.aggregates;

import cn.bugstack.ai.api.domain.zsxq.model.resp.RespData;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 未回答问题的聚合信息
 * @Date 2023/5/23 16:05
 * github:https://github.com/china-sebastian
 */
public class UnansweredQuestionAggregates {

    private boolean success;
    private RespData respData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public RespData getRespData() {
        return respData;
    }

    public void setRespData(RespData respData) {
        this.respData = respData;
    }
}


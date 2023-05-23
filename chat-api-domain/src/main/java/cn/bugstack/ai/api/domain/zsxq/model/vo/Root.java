package cn.bugstack.ai.api.domain.zsxq.model.vo;

import cn.bugstack.ai.api.domain.zsxq.model.resp.RespData;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 16:00
 * github:https://github.com/china-sebastian
 */
public class Root
{
    private boolean succeeded;

    private RespData resp_data;

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
    public void setResp_data(RespData resp_data){
        this.resp_data = resp_data;
    }
    public RespData getResp_data(){
        return this.resp_data;
    }
}
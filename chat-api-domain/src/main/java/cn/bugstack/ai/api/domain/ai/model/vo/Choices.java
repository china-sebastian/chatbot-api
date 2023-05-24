package cn.bugstack.ai.api.domain.ai.model.vo;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 19:21
 * github:https://github.com/china-sebastian
 */

public class Choices
{
    private Message message;

    private String finish_reason;

    private int index;

    public void setMessage(Message message){
        this.message = message;
    }
    public Message getMessage(){
        return this.message;
    }
    public void setFinish_reason(String finish_reason){
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason(){
        return this.finish_reason;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
}
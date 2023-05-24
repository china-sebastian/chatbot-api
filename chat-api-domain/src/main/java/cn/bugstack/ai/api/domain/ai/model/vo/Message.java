package cn.bugstack.ai.api.domain.ai.model.vo;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/24 16:45
 * github:https://github.com/china-sebastian
 */
public class Message
{
    private String role;

    private String content;

    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
}


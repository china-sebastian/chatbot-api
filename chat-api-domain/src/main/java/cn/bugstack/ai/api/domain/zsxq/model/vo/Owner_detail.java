package cn.bugstack.ai.api.domain.zsxq.model.vo;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 15:57
 * github:https://github.com/china-sebastian
 */
public class Owner_detail
{
    private String questions_count;

    private String join_time;

    public void setQuestions_count(String questions_count){
        this.questions_count = questions_count;
    }
    public String getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }
}

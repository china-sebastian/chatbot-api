package cn.bugstack.ai.api.domain.zsxq.model.resp;
import  java.util.*;
import cn.bugstack.ai.api.domain.zsxq.model.vo.Topics;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description 结果数据
 * @Date 2023/5/23 15:59
 * github:https://github.com/china-sebastian
 */
public class RespData
{
    private List<Topics> topics ;

    public void setTopics(List<Topics> topics){
        this.topics = topics;
    }
    public List<Topics> getTopics(){
        return this.topics;
    }
}


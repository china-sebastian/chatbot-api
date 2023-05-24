package cn.bugstack.ai.api.domain.ai.model.aggregates;

import cn.bugstack.ai.api.domain.ai.model.vo.Choices;
import cn.bugstack.ai.api.domain.ai.model.vo.Usage;

import java.util.*;
/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 19:24
 * github:https://github.com/china-sebastian
 */
//public class AIAnswer {
//
//    private String id;
//
//    private String object;
//
//    private int created;
//
//    private String model;
//
//    private Usage usage;
//
//    private List<Choices> choices;
//
//    public void setUsage(Object usage) {
//        this.usage = usage;
//    }
//
//    private List<Choices> choices;
//
//    public void setId(String id){
//        this.id = id;
//    }
//    public String getId(){
//        return this.id;
//    }
//    public void setObject(String object){
//        this.object = object;
//    }
//    public String getObject(){
//        return this.object;
//    }
//    public void setCreated(int created){
//        this.created = created;
//    }
//    public int getCreated(){
//        return this.created;
//    }
//    public void setModel(String model){
//        this.model = model;
//    }
//    public String getModel(){
//        return this.model;
//    }
//    public void setChoices(List<Choices> choices){
//        this.choices = choices;
//    }
//    public List<Choices> getChoices(){
//        return this.choices;
//    }
//
//}
public class AIAnswer
{
    private String id;

    private String object;

    private int created;

    private String model;

    private Usage usage;

    private List<Choices> choices;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObject(){
        return this.object;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setUsage(Usage usage){
        this.usage = usage;
    }
    public Usage getUsage(){
        return this.usage;
    }
    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }
}


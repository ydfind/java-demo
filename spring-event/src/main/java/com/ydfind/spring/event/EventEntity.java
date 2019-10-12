package com.ydfind.spring.event;

/**
 * 事件类
 * @author ydfind
 * @date 2019.10.12
 */
public class EventEntity {

    private Integer id;

    private String name;

    @Override
    public String toString(){
        return String.valueOf(id) + "," + name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}

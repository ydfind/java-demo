package com.ydfind.model;

import lombok.Data;

/**
 * 实体 员工
 * @author ydfind
 * @date 2019.10.15
 */
@Data
public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}

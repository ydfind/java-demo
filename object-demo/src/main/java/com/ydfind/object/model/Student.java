package com.ydfind.object.model;

import lombok.Data;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class Student {

    private Integer id;

    private Integer age;

    private String name;

    private String address;

    private String phone;

    private String sex;

    public Student(){

    }

    public Student(Integer id, Integer age, String name, String address, String phone, String sex){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
    }
}

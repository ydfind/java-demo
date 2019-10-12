package com.ydfind.object.model;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class Student1 {

    private Integer id;

    private Integer age;

    private String name;

    private String address;

    private String phone;

    private String sex;

    public Student1(){

    }

    public Student1(Integer id, Integer age, String name, String address, String phone, String sex){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void getPhone(String phone){
        this.phone = phone;
    }
}

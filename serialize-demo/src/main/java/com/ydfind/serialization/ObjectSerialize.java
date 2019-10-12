package com.ydfind.serialization;

import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    public static String sex="女";
    public transient String hobby="吃吃吃";
    public Student() {
        this.id=1;
    }
    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.id=2;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name +",sex="+sex+ ",hobby="+hobby+"]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class ObjectSerialize {

    public static void serializeExample() throws IOException, ClassNotFoundException {
        Student student = new Student(1, "丽日御茶子");
        System.out.println(student);
        student.setId(3);
        student.setHobby("玩玩玩");
        String filename = "D://tmp/temp.txt";
        FileOutputStream fos=new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        System.out.println(student);
        oos.close();

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2= (Student) ois.readObject();
        System.out.println(student2);
    }



}

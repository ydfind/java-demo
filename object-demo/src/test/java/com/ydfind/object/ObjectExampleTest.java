package com.ydfind.object;

import com.ydfind.object.model.Student;
import com.ydfind.object.model.Student1;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ObjectExampleTest {

    @Test
    public void testChangeStringToNull() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // public Student(Integer id, Integer age, String name, String address, String phone, String sex)
        Student student = new Student(1, 18, "张三", "", " ", "男");
        System.out.println("student define: " + student);
        ObjectExample.changeStringToNull(student);
        System.out.println("student process: " + student);
        Student1 student1 = new Student1(1, 18, " ", "", " ", "男");
        System.out.println("student1 define: " + student1);
        ObjectExample.changeStringToNull(student1);
        System.out.println("student1 process: " + student1);

    }
}

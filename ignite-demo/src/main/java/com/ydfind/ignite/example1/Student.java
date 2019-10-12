package com.ydfind.ignite.example1;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class Student{
    @QuerySqlField
    private int classId;

    @QuerySqlField
    private String name;

    @QuerySqlField
    private int age;

    public Student(int classId, String name, int age)
    {
        this.classId = classId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [classId=" + classId + ", name=" + name + ", age="
                + age + "]";
    }
}

package com.ydfind.object;

import com.alibaba.fastjson.JSON;
import com.ydfind.object.model.Student;
import org.apache.commons.beanutils.MethodUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommonsBeanutilsTest {

    @Test
    public void testCommonsBeanutils() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Student student = new Student();
        System.out.println(JSON.toJSONString(student));
        // 通过方法名和参数类型获得可访问方法
        Method method = MethodUtils.getAccessibleMethod(Student.class,
                "setId", Integer.class);
        method.invoke(student, 18);
        // 可以直接通过invokeMethod执行方法
        MethodUtils.invokeMethod(student, "setName", "张三");
        System.out.println(JSON.toJSONString(student));
    }
}

package com.ydfind.verify;

import com.ydfind.verify.oval.model.ClassInfo;
import com.ydfind.verify.oval.model.Student;
import lombok.extern.slf4j.Slf4j;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.List;

@Slf4j
public class StudentVerifyTest {

    @Test
    public void testVerify() {
        Student student = new Student();
        Validator validator = new Validator();
        // 初始化为正确的校验参数
        student.setId(10);
        student.setAge(8);
        student.setName("张三");
        student.setAddress("北京市");
        student.setPhone("18765230986");
        student.setSex("男");
        student.setEmail("yd@ydfind.com");
        student.setBirthDay("1996-10-05");
        ClassInfo classInfo = new ClassInfo();
        classInfo.setSchool("北京外国语大学");
        student.setClassInfo(classInfo);

        verifyStudent(validator, student);
        // 设置错误的参数
        student.setId(1);
        student.setAge(18);
        student.setName("李四");
        student.setSex("");
        student.setEmail("www.ydfind.com");
        student.getClassInfo().setSchool("");
        student.setBirthDay("1996.10.05");

        verifyStudent(validator, student);

        // 设置错误的参数
        student.setClassInfo(null);
        validator.disableProfile("profile1");

        verifyStudent(validator, student);
    }

    /**
     * 对对象进行校验
     * @param validator
     * @param obj
     */
    private static void verifyStudent(Validator validator, Object obj){
        List<ConstraintViolation> violations = validator.validate(obj);

        if(violations.size() > 0){
            log.info("----------------------Object is invalid:------------------");
            for(ConstraintViolation violation: violations){
                log.error(violation.getMessage());
            }
        } else {
            log.info("----------------------Object is valid:-------------------");
        }
    }
}

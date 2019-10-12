package com.ydfind.verify.oval.model;

import com.ydfind.verify.oval.TypeCheck;
import lombok.Data;
import net.sf.oval.constraint.*;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class Student {

    @NotNull(profiles = {"profile1"})
    @Length(min = 2, profiles = {"profile1"})
    private Integer id;

    @Length(max = 1, profiles = {"profile1"})
    private Integer age;

    @CheckWith(value = TypeCheck.class, message = "名称必须为张三")
    private String name;

    private String address;

    private String phone;

    @NotEmpty
    private String sex;

    /**
     * 递归校验,通常与notnull一起使用
     */
    @AssertValid
    private ClassInfo classInfo;

    @Email(profiles = {"profile1"})
    private String email;

    @DateRange(format = "yyyy-MM-dd", message = "日期格式不正确")
    private String birthDay;
}

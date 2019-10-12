package com.ydfind.verify.oval.model;

import lombok.Data;
import net.sf.oval.constraint.NotEmpty;

/**
 * entity类
 * @author ydfind
 * @date 2019.10.12
 */
@Data
public class ClassInfo {

    @NotEmpty
    private String school;
}

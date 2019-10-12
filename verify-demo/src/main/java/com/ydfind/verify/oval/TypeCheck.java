package com.ydfind.verify.oval;

import net.sf.oval.constraint.CheckWithCheck;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class TypeCheck implements CheckWithCheck.SimpleCheck{
    public static final String STR_TEST_NAME = "张三";
    @Override
    public boolean isSatisfied(Object o, Object o1) {
        if(o1 instanceof String && STR_TEST_NAME.equals((String)o1)){
            return true;
        }
        return false;
    }
}

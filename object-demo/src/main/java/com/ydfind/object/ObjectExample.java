package com.ydfind.object;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class ObjectExample {

    /**
     * 对象中字符串属性，若为空则设置为null
     * @param obj
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void changeStringToNull(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {

            Field[] fields = clazz.getDeclaredFields();

            // 遍历属性值，取得所有属性为 null 值的
            for (Field field : fields) {
                Type t = field.getGenericType();
                if (t.getTypeName().equals(String.class.getTypeName())) {
                    Object property = PropertyUtils.getProperty(obj, field.getName());
                    if (property != null && "".equals(String.valueOf(property).trim())) {
                        log.info("将设置{}为null", field.getName());
                        PropertyUtils.setProperty(obj, field.getName(), null);
                    }
                }
            }
        }
    }

}

package com.ydfind.guava;

import com.google.common.base.Joiner;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class StringJointDemo {
    public static void main(String[] args) {
        String join = Joiner.on("+").join("100353", "default", "application");
        String filename = String.format("%s.properties", join);
        System.out.println("join: " + join);
        System.out.println("join: " + filename);
    }
}

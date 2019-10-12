package com.ydfind.guava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
        String name = "aa,das,cc,dd,ee,cc,da,das,db";
        String[] appNames = name.split(",");
        Set<String> names = new HashSet<>(Arrays.asList(appNames));
        StringJoiner joiner = new StringJoiner(",");
        names.forEach(o -> joiner.add("'" + o + "'"));
        System.out.println(joiner.toString());
    }
}

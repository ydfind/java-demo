package com.ydfind.gof.factory;

/**
 * 图
 * @author ydfind
 * @date 2019.10.14
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("this is a circle.");
    }
}

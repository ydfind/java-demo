package com.ydfind.gof.factory;

/**
 * 矩形
 * @author ydfind
 * @date 2019.10.14
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("this is a rectangle.");
    }
}

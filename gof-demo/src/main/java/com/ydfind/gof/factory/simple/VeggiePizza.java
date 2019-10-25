package com.ydfind.gof.factory.simple;

import com.ydfind.gof.factory.simple.Pizza;

/**
 * 素食Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class VeggiePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("这是一个素食Pizza");
    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}

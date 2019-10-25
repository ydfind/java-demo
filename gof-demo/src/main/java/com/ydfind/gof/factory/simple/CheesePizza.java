package com.ydfind.gof.factory.simple;

/**
 * 奶酪Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("这是一个奶酪Pizza");
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

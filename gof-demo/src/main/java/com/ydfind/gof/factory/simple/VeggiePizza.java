package com.ydfind.gof.factory.simple;

/**
 * 素食Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class VeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("这是一个素食Pizza");
    }

}

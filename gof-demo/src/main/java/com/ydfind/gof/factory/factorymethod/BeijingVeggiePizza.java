package com.ydfind.gof.factory.factorymethod;

/**
 * 北京风味 素食Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class BeijingVeggiePizza extends Pizza1 {

    @Override
    public void prepare() {
        System.out.println("这是一个北京风味 素食Pizza");
    }

}

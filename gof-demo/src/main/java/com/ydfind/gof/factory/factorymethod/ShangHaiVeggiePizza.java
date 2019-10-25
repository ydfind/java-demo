package com.ydfind.gof.factory.factorymethod;

/**
 * 上海风味 素食Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class ShangHaiVeggiePizza extends Pizza1 {

    @Override
    public void prepare() {
        System.out.println("这是一个上海风味 素食Pizza");
    }
}

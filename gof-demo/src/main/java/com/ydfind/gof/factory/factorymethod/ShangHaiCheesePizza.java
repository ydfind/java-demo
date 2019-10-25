package com.ydfind.gof.factory.factorymethod;

/**
 * 上海风味 奶酪Pizza
 */
public class ShangHaiCheesePizza extends Pizza1 {
    @Override
    public void prepare() {
        System.out.println("这是一个 上海风味 奶酪Pizza");
    }

}

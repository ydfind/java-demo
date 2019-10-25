package com.ydfind.gof.factory.factorymethod;

/**
 * 北京风味 奶酪Pizza
 * @author ydifnd
 * @date 2019.10.25
 */
public class BeijingCheesePizza extends Pizza1 {
    @Override
    public void prepare() {
        System.out.println("这是一个 北京风味 奶酪Pizza");
    }
}

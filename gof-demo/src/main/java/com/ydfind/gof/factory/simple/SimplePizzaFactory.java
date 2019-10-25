package com.ydfind.gof.factory.simple;

import com.ydfind.gof.factory.simple.CheesePizza;
import com.ydfind.gof.factory.simple.Pizza;
import com.ydfind.gof.factory.simple.VeggiePizza;

/**
 * 简单Pizza工厂
 * @author ydfind
 * @date 2019.10.14
 */
public class SimplePizzaFactory {

    public static final String CHEESE_PIZZA = "奶酪Pizza";
    public static final String VEGGIE_PIZZA = "素食Pizza";

    /*******************************静态工厂，缺点：无法通过继承来修改创建行为************************************/
    /**
     * 根据关键字创建对象
     */
    public static Pizza createPizza(String type){
        switch (type){
            case CHEESE_PIZZA:
                return new CheesePizza();
            case VEGGIE_PIZZA:
                return new VeggiePizza();
            default:
                return null;
        }
    }
}

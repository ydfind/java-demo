package com.ydfind.gof.factory.factorymethod;

/**
 * Pizza店
 * @author ydfind
 * @date 2019.10.25
 */
public abstract class PizzaStore1 {
    public static final String CHEESE_PIZZA = "奶酪Pizza";
    public static final String VEGGIE_PIZZA = "素食Pizza";

    public Pizza1 orderPizza(String type){
        Pizza1 pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza1 createPizza(String type);
}

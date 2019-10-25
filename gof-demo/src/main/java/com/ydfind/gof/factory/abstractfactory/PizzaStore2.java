package com.ydfind.gof.factory.abstractfactory;

/**
 * Pizza店
 * @author ydfind
 * @date 2019.10.25
 */
public abstract class PizzaStore2 {
    public static final String CHEESE_PIZZA = "奶酪Pizza";
    public static final String VEGGIE_PIZZA = "素食Pizza";

    public Pizza2 orderPizza(String type){
        Pizza2 pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza2 createPizza(String type);
}

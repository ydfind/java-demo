package com.ydfind.gof.factory.simple;

/**
 * Pizza店
 * @author ydfind
 * @date 2019.10.25
 */
public class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = SimplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

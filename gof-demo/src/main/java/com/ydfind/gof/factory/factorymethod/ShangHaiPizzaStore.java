package com.ydfind.gof.factory.factorymethod;

/**
 * 上海Pizza店
 */
public class ShangHaiPizzaStore extends PizzaStore1 {

    @Override
    protected Pizza1 createPizza(String type) {
        switch (type){
            case CHEESE_PIZZA:
                return new ShangHaiCheesePizza();
            case VEGGIE_PIZZA:
                return new ShangHaiVeggiePizza();
            default:
                return null;
        }
    }
}

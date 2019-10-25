package com.ydfind.gof.factory.factorymethod;

/**
 * 北京Pizza店
 */
public class BeijingPizzaStore extends PizzaStore1 {

    @Override
    protected Pizza1 createPizza(String type) {
        switch (type){
            case CHEESE_PIZZA:
                return new BeijingCheesePizza();
            case VEGGIE_PIZZA:
                return new BeijingVeggiePizza();
            default:
                return null;
        }
    }
}

package com.ydfind.gof.factory.abstractfactory;

/**
 * 上海Pizza店
 * @author ydifnd
 * @date 2019.10.25
 */
public class ShangHaiPizzaStore2 extends PizzaStore2 {

    @Override
    protected Pizza2 createPizza(String type) {
        switch (type){
            case CHEESE_PIZZA:
                return new CheesePizza2(new ShangHaiIngredientFactory());
            case VEGGIE_PIZZA:
                return new VeggiePizza2(new ShangHaiIngredientFactory());
            default:
                return null;
        }
    }
}

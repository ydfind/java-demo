package com.ydfind.gof.factory.abstractfactory;

/**
 * 北京Pizza店
 * @author ydifnd
 * @date 2019.10.25
 */
public class BeijingPizzaStore2 extends PizzaStore2 {

    @Override
    protected Pizza2 createPizza(String type) {
        switch (type){
            case CHEESE_PIZZA:
                return new CheesePizza2(new BeijingIngredientFactory());
            case VEGGIE_PIZZA:
                return new VeggiePizza2(new BeijingIngredientFactory());
            default:
                return null;
        }
    }
}

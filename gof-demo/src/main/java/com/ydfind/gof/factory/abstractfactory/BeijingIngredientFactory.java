package com.ydfind.gof.factory.abstractfactory;

/**
 * 北京Pizza原料工厂
 * @author ydifnd
 * @date 2019.10.25
 */
public class BeijingIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new BeijingDough();
    }

    @Override
    public Sauce createSauce() {
        return new BeijingSauce();
    }
}

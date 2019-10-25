package com.ydfind.gof.factory.abstractfactory;

/**
 * 上海Pizza原料工厂
 * @author ydifnd
 * @date 2019.10.25
 */
public class ShangHaiIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new ShangHaiDough();
    }

    @Override
    public Sauce createSauce() {
        return new ShangHaiSauce();
    }
}

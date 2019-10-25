package com.ydfind.gof.factory.abstractfactory;

/**
 * Pizza原料工厂
 * @author ydifnd
 * @date 2019.10.25
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
}

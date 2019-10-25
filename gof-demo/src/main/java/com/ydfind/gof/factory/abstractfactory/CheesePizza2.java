package com.ydfind.gof.factory.abstractfactory;

/**
 * 奶酪Pizza
 * @author ydfind
 * @date 2019.10.14
 */
public class CheesePizza2 extends Pizza2 {

    public CheesePizza2(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        this.setDough(this.getIngredientFactory().createDough());
        this.setSauce(this.getIngredientFactory().createSauce());
    }

}

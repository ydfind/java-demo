package com.ydfind.gof.factory.abstractfactory;

/**
 * 素食Pizza
 * @author ydfind
 * @date 2019.10.25
 */
public class VeggiePizza2 extends Pizza2 {

    public VeggiePizza2(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }
    
    @Override
    public void prepare() {
        this.setDough(this.getIngredientFactory().createDough());
        this.setSauce(this.getIngredientFactory().createSauce());
    }
}

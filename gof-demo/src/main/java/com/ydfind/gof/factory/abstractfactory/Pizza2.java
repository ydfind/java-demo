package com.ydfind.gof.factory.abstractfactory;

import lombok.Data;

/**
 * 制作pizza 接口
 * @author ydfind
 * @date 2019.10.25
 */
@Data
public abstract class Pizza2 {
    private Dough dough;
    private Sauce sauce;

    private PizzaIngredientFactory ingredientFactory;

    public Pizza2(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * 准备
     */
    public void prepare(){
        this.setDough(this.getIngredientFactory().createDough());
        this.setSauce(this.getIngredientFactory().createSauce());
    }

    /**
     * 烘烤
     */
    public void bake(){
    }

    /**
     * 切片
     */
    public void cut(){
    }

    /**
     * 装盒
     */
    public void box(){
    }
}

package com.ydfind.gof.factory;

import com.ydfind.gof.factory.simple.Pizza;
import com.ydfind.gof.factory.simple.VeggiePizza;

/**
 * 具体产品2的工厂类
 * @author ydfind
 * @date 2019.10.14
 */
public class Factory2 implements Factory {

    @Override
    public Pizza createProduct() {
        return new VeggiePizza();
    }
}

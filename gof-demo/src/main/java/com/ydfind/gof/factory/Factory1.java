package com.ydfind.gof.factory;

/**
 * 具体产品1的工厂类
 * @author ydfind
 * @date 2019.10.14
 */
public class Factory1 implements Factory {

    @Override
    public Product createProduct() {
        return new Product1();
    }
}

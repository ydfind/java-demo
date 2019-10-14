package com.ydfind.gof.factory;

/**
 * 具体产品2的工厂类
 * @author ydfind
 * @date 2019.10.14
 */
public class Factory2 implements Factory {

    @Override
    public Product createProduct() {
        return new Product2();
    }
}

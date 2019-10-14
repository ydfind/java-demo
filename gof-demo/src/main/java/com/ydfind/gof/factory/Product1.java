package com.ydfind.gof.factory;

/**
 * 产品1
 * @author ydfind
 * @date 2019.10.14
 */
public class Product1 implements Product {

    @Override
    public void productMethod(){
        System.out.println("this is product1");
    }
}

package com.ydfind.gof.factory;
/**
 * 产品A的简单工厂类
 * @author ydfind
 * @date 2019.10.14
 */
public class SimpleFactory {

    public static final String PRODUCT_1 = "1";
    public static final String PRODUCT_2 = "2";

    /*******************************简单-工厂*********************************************/
    /**
     * 根据关键字创建对象
     */
    public Product createProduct(String type){
        Product product;
        switch (type){
            case PRODUCT_1:
                product = new Product1();
                break;
            case PRODUCT_2:
                product = new Product2();
                break;
            default:
                product = null;
        }
        return product;
    }

    /*****************************多方法-工厂***********************************************/
    public Product createProduct1(){
        return new Product1();
    }

    public Product createProduct2(){
        return new Product2();
    }

    /*****************************静态-工厂***********************************************/
    public static Product createStaticProduct1(){
        return new Product1();
    }

    public static Product createStaticProduct2(){
        return new Product2();
    }
}

package com.ydfind.gof.factory;

import com.ydfind.gof.factory.simple.Pizza;

/**
 * 产品的工厂模式接口
 * @author ydfind
 * @date 2019.10.14
 */
public interface Factory {

    /**
     * 创建产品对象
     * @return 产品对象
     */
    Pizza createProduct();
}

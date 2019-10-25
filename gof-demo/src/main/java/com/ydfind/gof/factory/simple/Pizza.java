package com.ydfind.gof.factory.simple;

/**
 * 制作pizza 接口
 * @author ydfind
 * @date 2019.10.14
 */
public interface Pizza {

    /**
     * 准备
     */
    void prepare();

    /**
     * 烘烤
     */
    void bake();

    /**
     * 切片
     */
    void cut();

    /**
     * 装盒
     */
    void box();
}

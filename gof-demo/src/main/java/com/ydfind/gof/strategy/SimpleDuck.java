package com.ydfind.gof.strategy;

/**
 * 普通鸭子：无法飞行
 * @author ydfind
 * @date 2019.10.25
 */
public class SimpleDuck extends Duck {
    public SimpleDuck(){
        this.setFlyStrategy(new FlyNoWay());
    }
}

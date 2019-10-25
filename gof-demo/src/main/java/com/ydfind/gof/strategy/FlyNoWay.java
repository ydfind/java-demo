package com.ydfind.gof.strategy;

/**
 * 无法飞行
 * @author ydfind
 * @date 2019.10.25
 */
public class FlyNoWay implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("无法飞行");
    }
}

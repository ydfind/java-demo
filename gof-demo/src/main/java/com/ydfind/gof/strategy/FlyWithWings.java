package com.ydfind.gof.strategy;

/**
 * 翅膀飞翔
 * @author ydfind
 * @date 2019.10.25
 */
public class FlyWithWings implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("翅膀飞翔");
    }
}

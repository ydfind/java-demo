package com.ydfind.gof.strategy;

/**
 * 天鹅:能飞
 * @author ydfind
 * @date 2019.10.25
 */
public class SwanDuck extends Duck{

    public SwanDuck(){
        this.setFlyStrategy(new FlyWithWings());
    }
}

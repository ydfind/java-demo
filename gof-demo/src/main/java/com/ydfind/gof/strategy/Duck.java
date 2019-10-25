package com.ydfind.gof.strategy;

import lombok.Data;

/**
 * 鸭子基类
 * @author ydfind
 * @date 2019.10.25
 */
@Data
public abstract class Duck {

    private FlyStrategy flyStrategy;

    public void performFly(){
        flyStrategy.fly();
    }
}

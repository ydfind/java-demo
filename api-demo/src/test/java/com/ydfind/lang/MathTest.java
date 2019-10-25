package com.ydfind.lang;

import org.junit.Test;

/**
 * Math类测试
 * @author ydfind
 * @date 2019.10.17
 */
public class MathTest {

    /**
     * atan参数负无穷到正无穷，值-PI/2 到 PI/2；
     * atan2参数为坐标yx，值为-PI 到 PI;
     */
    @Test
    public void testTan(){
        double atan2;
        double angle;

        // 45
        atan2 = Math.atan2(1, 1);
        angle = atan2 / Math.PI * 180;
        System.out.println(angle + "," + atan2);
        // 135
        atan2 = Math.atan2(1, -1);
        angle = atan2 / Math.PI * 180;
        System.out.println(angle + "," + atan2);
        // 225
        atan2 = Math.atan2(-1, -1);
        angle = atan2 / Math.PI * 180;
        System.out.println(angle + "," + atan2);
        // 315
        atan2 = Math.atan2(-1, 1);
        angle = atan2 / Math.PI * 180;
        System.out.println(angle + "," + atan2);

        double atan;
        // 0
        atan = Math.atan(0);
        angle = atan / Math.PI * 180;
        System.out.println(angle + "," + atan);
        // 1
        atan = Math.atan(1);
        angle = atan / Math.PI * 180;
        System.out.println(angle + "," + atan);
        // -1
        atan = Math.atan(-1);
        angle = atan / Math.PI * 180;
        System.out.println(angle + "," + atan);
    }

    @Test
    public void testACos(){
        double degrees = 0;
        double radians = Math.toRadians(degrees);
        double cos = Math.cos(radians);
        double acos = Math.acos(cos);

        System.out.println("radians = " + radians);
        System.out.println("cos = " + cos);
        System.out.println("acos = " + acos);
    }
}

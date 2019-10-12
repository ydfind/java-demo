package com.ydfind.ignite.debug;

import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;

/**
 * Ignite报错调试代码
 *
 * @author : ydfind
 * @date : 2019-08-13
 */
public class IgniteDubegExample {
    public static void main(String[] args) throws IgniteException {
        String filename = "D:\\YDGreen\\apache-ignite-fabric-2.6.0-bin/examples/config/example-ignite.xml";
        Ignition.start(filename);
    }
}

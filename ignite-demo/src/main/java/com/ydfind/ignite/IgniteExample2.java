package com.ydfind.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;

/**
 * Ignite例子2
 * @author ydfind
 * @date 2019.10.12
 */
public class IgniteExample2 {
    public static void main(String[] args) throws IgniteException {
        String filename = "D:\\YDGreen\\apache-ignite-fabric-2.6.0-bin/examples/config/example-ignite.xml";
        filename = "D:\\PGreen\\ignite-2.7.5" + "/examples/config/example-ignite.xml";
        try (Ignite ignite = Ignition.start(filename)) {
            // Put values in cache.
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");

            cache.put(1, "Hello");
            cache.put(2, "World!");

            // Get values from cache and
            // broadcast 'Hello World' on all the nodes in the cluster.
            ignite.compute().broadcast(() -> {
                String hello = cache.get(1);
                String world = cache.get(2);

                System.out.println(hello + " " + world);
            });
        }
    }
}

//package com.ydfind.ignite.zookeeper;
//
//import org.apache.ignite.Ignite;
//import org.apache.ignite.IgniteCache;
//import org.apache.ignite.Ignition;
//import org.apache.ignite.cache.CacheMode;
//import org.apache.ignite.configuration.CacheConfiguration;
//import org.apache.ignite.configuration.IgniteConfiguration;
//import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
//import org.apache.ignite.spi.discovery.tcp.ipfinder.zk.TcpDiscoveryZookeeperIpFinder;
//
//public class IgniteCluster02
//{
//    public static void main(String[] args)
//    {
//        TcpDiscoverySpi spi = new TcpDiscoverySpi();
//        TcpDiscoveryZookeeperIpFinder ipFinder = new TcpDiscoveryZookeeperIpFinder();
//        // Specify ZooKeeper connection string.
//        ipFinder.setZkConnectionString("10.0.55.82:2181,10.0.55.82:2182,10.0.55.82:2183");
//        spi.setIpFinder(ipFinder);
//        IgniteConfiguration cfg = new IgniteConfiguration();
//        // Override default discovery SPI.
//        cfg.setDiscoverySpi(spi);
//        // Start Ignite node.
//        Ignite ignite =Ignition.start(cfg);
//        System.out.println("IgniteCluster2 start OK.");
//        CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<Integer, String>();
//        cacheCfg.setBackups(1);
//        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
//        cacheCfg.setName("myCache");
//        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cacheCfg);
//        cache.put(2, "ignite2");
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//    }
//}

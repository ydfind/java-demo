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
///**
// *
// * IgniteCluster01.java Create on 2017年6月3日 下午10:52:38
// *
// * 类功能说明:   基于zookeeper集群
// *
// * Copyright: Copyright(c) 2013
// * Company: COSHAHO
// * @Version 1.0
// * @Author coshaho
// */
//public class IgniteCluster01
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
//
//        System.out.println("IgniteCluster1 start OK.");
//        CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<Integer, String>();
//        cacheCfg.setBackups(1);
//        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
//        cacheCfg.setName("myCache");
//        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cacheCfg);
//        cache.put(1, "ignite1");
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//    }
//}
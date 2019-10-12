//package com.ydfind.ignite;
//
//import org.apache.ignite.Ignition;
//import org.apache.ignite.configuration.IgniteConfiguration;
//import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
//import org.apache.ignite.spi.discovery.tcp.ipfinder.zk.TcpDiscoveryZookeeperIpFinder;
//
//public class IgniteExample4 {
//
//    /**
//     * IGNITE INSTANCE
//     */
//    public static  final String IGNITEINSTANCE_NAME= "springDataNode";
//
//    public static void main(String[] args) {
//
//        IgniteConfiguration cfg = new IgniteConfiguration();
//        cfg.setClientMode(true);
//        cfg.setPeerClassLoadingEnabled(false);
//        cfg.setIgniteInstanceName(IGNITEINSTANCE_NAME);
//        System.out.println("------------------IGNITEINSTANCE_NAME--:" + IGNITEINSTANCE_NAME);
//        cfg.setMetricsLogFrequency(0);
//        TcpDiscoverySpi discovery = new TcpDiscoverySpi();
//        discovery.setAckTimeout(20000);
//        discovery.setNetworkTimeout(20000);
//        TcpDiscoveryZookeeperIpFinder ipFinder = new TcpDiscoveryZookeeperIpFinder();
//        String igniteAddress = "10.0.21.56:2181,10.0.21.57:2181,10.0.21.58:2181,10.0.21.59:2181,10.0.21.60:2181";
//        System.out.println("------------------igniteAddress--:" + igniteAddress);
//        ipFinder.setZkConnectionString(igniteAddress);
//        discovery.setIpFinder(ipFinder);
//        cfg.setDiscoverySpi(discovery);
//        System.out.println("-----------------------------------start-------------------");
//        Ignition.start(cfg);
//        System.out.println("-------------------------------------------end-------------------");
//    }
//}

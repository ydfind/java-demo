package com.ydfind.ignite.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Ignite工具类
 * @author ydfind
 * @date 2019.10.12
 */
public class IgniteUtils {

    public static final Integer TIME_OUT = 3000;

    /**
     * jdk的直接判断
     * @param hostname
     * @return
     */
    public static final boolean isNodeReachable(String hostname) {
        try {
            InetAddress addr = InetAddress.getByName(hostname);
            if (addr.isReachable(TIME_OUT)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(hostname + "网络不可达！");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 网上的一个例子，ignite使用的是另外一种方式
     * @return
     * @throws Exception
     */
    public static List<InetAddress> getLocalIp() throws Exception {
        List<InetAddress> locAddrs = new ArrayList();
        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();

        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();

            // 获得与该网络接口绑定的 IP 地址，一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
// 只关心 IPv4 地址
                if (addr instanceof Inet4Address) {
                    locAddrs.add(addr);
                }
            }
        }
        return locAddrs;
    }

}

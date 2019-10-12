package com.ydfind.ignite.util;

import com.ydfind.ignite.util.IgniteUtils;
import org.junit.Test;

import java.net.InetAddress;
import java.util.List;

public class IgniteUtilTest {

    @Test
    public void testGetLocalIp() throws Exception {
        List<InetAddress> addres;
        addres = IgniteUtils.getLocalIp();
        System.out.println(addres);
    }

    @Test
    public void testIsNodeReachable(){
        boolean ok = IgniteUtils.isNodeReachable("127.0.0.1");
        System.out.println("可达：" + ok);
    }
}

package com.ydfind.ignite.debug;

import org.apache.ignite.IgniteException;
import org.apache.ignite.internal.util.IgniteUtils;
import org.apache.ignite.internal.util.typedef.F;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Ignite网络调试简单例子
 *
 * @author : ydfind
 * @date : 2019-08-13
 */
public class IgniteSimpleNetExample {

    public static void main(String[] args) throws SocketException {
        List<InetAddress> addrs = getAddrs();
        System.out.println("本地地址" + addrs);
        addrs = filterReachable(addrs);
        System.out.println("过滤后本地地址" + addrs);
    }

    /**
     * ignite的网络过滤
     * @param addrs
     * @return
     */
    public static List<InetAddress> filterReachable(Collection<InetAddress> addrs) {
        if (addrs.isEmpty()) {
            return Collections.emptyList();
        } else {
            long startTime = System.currentTimeMillis();
            if (addrs.size() == 1) {
                InetAddress addr = (InetAddress) F.first(addrs);
                return reachable(addr, 2000) ? Collections.singletonList(addr) : Collections.emptyList();
            } else {
                final List<InetAddress> res = new ArrayList(addrs.size());
                Collection<Future<?>> futs = new ArrayList(addrs.size());
                int nThreads = Math.min(10, addrs.size());
                ExecutorService executor = new ThreadPoolExecutor(nThreads, nThreads,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

                try {
                    Iterator var5 = addrs.iterator();

                    while(var5.hasNext()) {
                        final InetAddress addr = (InetAddress)var5.next();
                        futs.add(executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                if (reachable(addr, 3000)) {
                                    synchronized(res) {
                                        res.add(addr);
                                    }
                                }

                            }
                        }));
                    }

                    var5 = futs.iterator();

                    while(var5.hasNext()) {
                        Future fut = (Future)var5.next();
                        System.out.println("time:" + (System.currentTimeMillis() -startTime));

                        try {
                            fut.get();
                        } catch (InterruptedException var12) {
                            Thread.currentThread().interrupt();
                            throw new IgniteException("Thread has been interrupted.", var12);
                        } catch (ExecutionException var13) {
                            throw new IgniteException(var13);
                        }
                    }
                } finally {
                    executor.shutdown();
                }

                System.out.println("total time:" + (System.currentTimeMillis() -startTime));
                return res;
            }
        }
    }

    /**
     *
     * @param addr
     * @param reachTimeout
     * @return
     */
    public static boolean reachable(InetAddress addr, int reachTimeout) {
        try {
            boolean reached = addr.isReachable(reachTimeout);
            return reached;
        } catch (IOException var3) {
            return false;
        }
    }

    public static List<InetAddress> getAddrs() throws SocketException {
        List<InetAddress> locAddrs = new ArrayList();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        Iterator var6 = IgniteUtils.asIterable(networkInterfaces).iterator();

        while(var6.hasNext()) {
            NetworkInterface itf = (NetworkInterface)var6.next();
            Iterator var8 = IgniteUtils.asIterable(itf.getInetAddresses()).iterator();

            while(var8.hasNext()) {
                InetAddress addr = (InetAddress)var8.next();
                if (!addr.isLinkLocalAddress()) {
                    locAddrs.add(addr);
                }
            }
        }
        return locAddrs;
    }
}

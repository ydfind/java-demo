package com.ydfind.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
/**
 * 主程序入口
 * @author ydfind
 * @date 2019.10.12
 */
public class MainApp {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183",
                30000, new TestWatcher());
        String node = "/node2";
        Stat stat = zk.exists(node, false);
        if(null == stat){
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }
}

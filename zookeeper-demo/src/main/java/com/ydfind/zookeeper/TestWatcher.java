package com.ydfind.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class TestWatcher implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("---------------------TestWatcher.process start--------------------------");
        System.out.println("path: " + watchedEvent.getPath());
        System.out.println("path: " + watchedEvent.getType());
        System.out.println("path: " + watchedEvent.getState());
        System.out.println("---------------------TestWatcher.process end----------------------------");
    }
}

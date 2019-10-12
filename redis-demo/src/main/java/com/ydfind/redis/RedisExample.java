package com.ydfind.redis;


import redis.clients.jedis.Jedis;

/**
 * redis调用示例
 * @author ydfind
 * @date 2019.09.29
 */
public class RedisExample {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        System.out.println("connect successful!");
        System.out.println("service running: "+jedis.ping());
    }
}

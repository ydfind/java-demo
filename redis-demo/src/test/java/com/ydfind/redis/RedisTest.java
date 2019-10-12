package com.ydfind.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * redis测试类
 * @author ydfind
 * @date 2019.09.29
 */
public class RedisTest {

    /**
     * 创建连接
     * @return redis实例
     */
    public Jedis createJedis(){
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        return jedis;
    }

    @Test
    public void testRedis(){
        System.out.println("-------------------测试redis实例创建-----------------");
        Jedis jedis = createJedis();
        System.out.println("connect successful!");
        System.out.println("service running: "+jedis.ping());
        System.out.println("-------------------测试字符串-----------------");
        jedis.set("name", "ydfind");
        System.out.println("key name = "+ jedis.get("name"));

        System.out.println("-------------------测试List-----------------");
        jedis.lpush("myList", "item1");
        jedis.lpush("myList", "item2");
        jedis.lpush("myList", "item3");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("myList", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("item" + (i + 1) + " = "+list.get(i));
        }
        System.out.println("-------------------测试Set-----------------");
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}

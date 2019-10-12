package com.ydfind.kafka.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消费者测试类
 * @author ydfind
 * @date 2019.10.12
 */
public class ConsumerTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-kafka-consumer.xml");
    }
}

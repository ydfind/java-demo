package com.ydfind.kafka.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.MessageListener;


/**
 * kafka消费者监听类
 * @author ydfind
 * @date 2019.10.12
 */
public class KfkConsumerListener implements MessageListener<String, String> {

    /**
     * 监听器自动执行该方法
     * 消费消息
     * 自动提交offset
     *
     * @param record
     */
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.printf("partition = %d, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
    }
}

package com.ydfind.kafka.simple;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
/**
 * kafka生产者类
 * @author ydfind
 * @date 2019.10.12
 */
public class KfkProducer {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<String, Object>(8);
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String topic = "test-topic";
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 1"));
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 2"));
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 3"));

        producer.close();
    }
}

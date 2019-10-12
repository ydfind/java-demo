package com.ydfind.kafka.report.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Configuration
@EnableKafka
public class TopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>(8);
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.BOOTSTRAP_SERVERS);
        return new KafkaAdmin(configs);
    }

    @Bean(name = Constants.TOPIC_PAGE)
    public NewTopic pageTopic() {
        return new NewTopic(Constants.TOPIC_PAGE, 10, (short) 2);
    }

    @Bean(name = Constants.TOPIC_CLICK)
    public NewTopic clickTopic() {
        return new NewTopic(Constants.TOPIC_CLICK, 10, (short) 2);
    }
}

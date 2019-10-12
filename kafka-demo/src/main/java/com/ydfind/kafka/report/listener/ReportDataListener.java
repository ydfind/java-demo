package com.ydfind.kafka.report.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import com.ydfind.kafka.report.config.Constants;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class ReportDataListener {

    private static Logger logger = LoggerFactory.getLogger(ReportDataListener.class);

    @KafkaListener(id = Constants.REPORT_DATA_CONTAINER, topics = {Constants.TOPIC_PAGE, Constants.TOPIC_CLICK})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("监听到消息记录 ===============");
        logger.info("topic = " + record.topic());
        logger.info("partition = " + record.partition());
        logger.info("offset = " + record.offset());
        logger.info("key = " + record.key());
        logger.info("value = " + record.value());
        logger.info("----------------------------");

    }

}

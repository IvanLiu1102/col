package com.col.module;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by liu.min on 2018/11/29.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test2")
    private void receiver(ConsumerRecord<String,String> record){
        System.out.printf("消费消息：topic=%s, partition=%d, offset=%d, key=%s, value=%s\n",
                record.topic(), record.partition(), record.offset(), record.key(), record.value());
    }
}

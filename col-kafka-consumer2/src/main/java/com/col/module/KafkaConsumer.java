package com.col.module;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by liu.min on 2018/11/29.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test2")
    private void receiver(String message){
        System.out.println("consumer2 收到消息==========" + message);
    }
}

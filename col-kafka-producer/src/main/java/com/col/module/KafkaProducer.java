package com.col.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * Created by liu.min on 2018/11/29.
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 定时任务
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("test2",message);
        future.addCallback(
                success -> System.out.println("send-消息发送成功：" + message),
                fail -> System.out.println("消息发送失败：" + message)
        );
    }
}

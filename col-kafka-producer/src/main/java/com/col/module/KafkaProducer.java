package com.col.module;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

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
    @Scheduled(cron = "00/5 * * * * ?")
    public void send(){
        String message = UUID.randomUUID().toString();
        ProducerRecord<String,String> record = new ProducerRecord<>("test2", UUID.randomUUID().toString());
        try {
            SendResult sendResult = (SendResult)kafkaTemplate.send(record).get();
            RecordMetadata result = sendResult.getRecordMetadata();
            System.out.printf("同步发送：%s，分区：%d，offset：%d\n", result.topic(),
                    result.partition(), result.offset());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

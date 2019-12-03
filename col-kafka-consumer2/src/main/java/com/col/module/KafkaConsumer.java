package com.col.module;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by liu.min on 2018/11/29.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test2",errorHandler = "consumerAwareErrorHandler")
    private void receiver(ConsumerRecord<String,String> record){
        System.out.printf("消费消息：topic=%s, partition=%d, offset=%d, key=%s, value=%s\n",
                record.topic(), record.partition(), record.offset(), record.key(), record.value());
        throw new RuntimeException();
    }


    @Bean("consumerAwareErrorHandler")
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return new ConsumerAwareListenerErrorHandler() {
            @Override
            public Object handleError(Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) {
                System.out.println("consumerAwareErrorHandler receive : "+message.getPayload().toString());
                return null;
            }
        };
    }
}

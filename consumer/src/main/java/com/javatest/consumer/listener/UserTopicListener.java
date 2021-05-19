package com.javatest.consumer.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UserTopicListener {

    @KafkaListener(topicPattern = "users", groupId = "test-consumer-group")
    public void consume(String message) {
        log.info("A new message has arrived: {}", message);
    }
}

package com.javatest.producer.service;

import com.javatest.producer.user.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("user-publisher")
public class UserPublisherService implements PublisherService<User>{

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topicName;

    @Autowired
    public UserPublisherService(final KafkaTemplate<String, Object> kafkaTemplate,
                                @Value("${kafka.topic.users}") final String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void publish(User message) {

        if (Objects.isNull(message)) {
            throw new IllegalStateException("User can't be null");
        }

        kafkaTemplate.send(topicName, message.toString());
    }
}

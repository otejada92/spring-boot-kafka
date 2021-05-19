package com.javatest.producer.service;

import com.javatest.producer.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("user-publisher")
@Log4j2
public class UserPublisherService implements PublisherService<User>{

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topicName;

    @Autowired
    public UserPublisherService(final KafkaTemplate<String, Object> kafkaTemplate,
                                final @Value("${kafka.topic.users}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void publish(User message) {

        log.info("A new user is about to be published.");

        if (Objects.isNull(message)) {
            log.error("User is empty, it won't published.");
            throw new IllegalStateException("User can't be null");
        }

        kafkaTemplate.send(topicName, message.toString());

        log.info("A new user has been published. {}", message.toString());
    }
}

package com.javatest.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    private final Integer replicationFactor;
    private final short partitions;
    private final String topicName;

    public KafkaTopicConfiguration(final @Value("${kafka.replication.factor}") Integer replicationFactor,
                                   final @Value("${kafka.partitions}") short partitions,
                                   final @Value("${kafka.topic.users}") String topicName) {

        this.replicationFactor = replicationFactor;
        this.partitions = partitions;
        this.topicName  = topicName;
    }


    @Bean
    public NewTopic userTopic() {
        return TopicBuilder
                .name(topicName)
                .partitions(partitions)
                .replicas(replicationFactor)
                .build();
    }
}

package com.example.kafka.application.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicTest() {
        return TopicBuilder.name("Test").build();
    }

    @Bean
    public NewTopic topicUser() {
        return TopicBuilder.name("User").build();
    }
}

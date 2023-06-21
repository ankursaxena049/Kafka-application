package com.example.kafka.application.consumers;

import com.example.kafka.application.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "Test", groupId = "kafkaGroup")
    public void processMessageTest(String message) {
        LOGGER.info(String.format("Message Processed for Test -> %s", message));
    }

    @KafkaListener(topics = "User", groupId = "kafkaGroup")
    public void processMessageUser(User user) {
        LOGGER.info(String.format("Message Processed for User -> %s", user.toString()));
    }
}

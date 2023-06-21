package com.example.kafka.application.producers;

import com.example.kafka.application.entities.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessageToUser(User user) {
        LOGGER.info(String.format("Message sent for user: %s", user.toString()));
        Message<User> userMessage = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "User")
                .build();
        kafkaTemplate.send(userMessage);
    }
}

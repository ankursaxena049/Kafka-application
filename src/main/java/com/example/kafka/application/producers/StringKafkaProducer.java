package com.example.kafka.application.producers;

import com.example.kafka.application.entities.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StringKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToTest(String message) {
        LOGGER.info(String.format("Message sent for test: %s", message));
        kafkaTemplate.send("Test", message);
    }
}

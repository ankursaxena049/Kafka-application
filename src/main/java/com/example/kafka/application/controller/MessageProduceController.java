package com.example.kafka.application.controller;

import com.example.kafka.application.entities.User;
import com.example.kafka.application.producers.JsonKafkaProducer;
import com.example.kafka.application.producers.StringKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/publish")
@RequiredArgsConstructor
public class MessageProduceController {

    private final StringKafkaProducer stringKafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/test")
    public ResponseEntity<String> sendMessageToTest(@RequestParam("message") String message) {
        stringKafkaProducer.sendMessageToTest(message);
        return ResponseEntity.ok("Message Sent to Test Topic!!");
    }

    @PostMapping("/user")
    public ResponseEntity<String> sendMessageToUser(@RequestBody User user) {
        jsonKafkaProducer.sendMessageToUser(user);
        return ResponseEntity.ok("Message Sent to User Topic!!");
    }
}

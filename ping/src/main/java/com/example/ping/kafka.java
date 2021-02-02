package com.example.ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class kafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/ping")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.kafkaTemplate.send("pong", message);
    }
}
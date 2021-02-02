package com.example.ping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class pandc {

    private static final Logger logger = LoggerFactory.getLogger(pandc.class);
    private static final String TOPIC = "ping";
    boolean msg = true;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "pong", groupId = "ping_group")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Producing message -> %s", message));
        if(message.equals("stop"))
            msg=false;
        if(message.equals("start"))
            msg=true;
        if(!msg)
            return;
        this.kafkaTemplate.send(TOPIC, "From Ping");
    }
}


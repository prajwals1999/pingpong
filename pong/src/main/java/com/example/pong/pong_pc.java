package com.example.pong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class pong_pc {

    private static final Logger logger = LoggerFactory.getLogger(pong_pc.class);
    private static final String TOPIC = "pong";
    boolean msg=true;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "ping", groupId = "pong_group")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Producing message -> %s", message));
        if(message.equals("stop"))
            msg=false;
        if(message.equals("start"))
            msg=true;
        if(!msg)
            return;
        this.kafkaTemplate.send(TOPIC,"From pong");
    }
}

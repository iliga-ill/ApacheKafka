package com.example.apachekafka.kafka;

import com.example.apachekafka.kafka.payload.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class JsonKafkaProducer {
//
//    private final KafkaTemplate<String, User> kafkaTemplate;
//
//    public void sendMessage(User data) {
//
//        log.info(String.format("Message sent -> %s", data.toString()));
//
//        Message<User> message = MessageBuilder
//                .withPayload(data)
//                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
//                .build();
//
//        kafkaTemplate.send(message);
//    }
//
//    @Scheduled(fixedDelay = 10000)
//    private void sendMessage(){
//        sendMessage(User.builder()
//                .id(1)
//                .firstName("1")
//                .lastName("1")
//                .build()
//        );
//    }
//}

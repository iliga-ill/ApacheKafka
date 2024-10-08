package com.example.apachekafka.kafka;

import com.example.apachekafka.kafka.payload.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class JsonKafkaConsumer {
//
//    @KafkaListener(
//            topics = "jsonTopic",
//            groupId = "myGroup"
//    )
//    public void consumer(User message){
//        log.info(String.format("Message received -> %s", message.toString()));
//    }
//
//}

package com.example.apachekafka.kafka;

import com.example.apachekafka.kafka.payload.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    @KafkaListener(
            topics = "stringTopic",
            groupId = "myGroup",
            containerFactory = "stringKafkaListenerContainerFactory"
    )
    public void consumer(String message){
        log.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(
            topics = "jsonTopic",
            groupId = "myGroup",
            containerFactory = "userKafkaListenerContainerFactory"
    )
    public void consumer(User message){
        log.info(String.format("Message received -> %s", message.toString()));
    }

}

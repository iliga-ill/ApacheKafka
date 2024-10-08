package com.example.apachekafka.kafka;

import com.example.apachekafka.kafka.payload.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("KafkaProducer")
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaStringTemplate;
    private final KafkaTemplate<String, User> kafkaJsonTemplate;

    public void sendMessage(String message) {
        log.info(String.format("Message sent: '%s'", message));
        kafkaStringTemplate.send("stringTopic", message);
    }

    public void sendMessage(User data) {
        log.info(String.format("Message sent -> %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();
        kafkaJsonTemplate.send(message);
    }

    @Scheduled(fixedDelay = 10000)
    private void sendMessage(){
        sendMessage(User.builder()
                .id(1)
                .firstName("1")
                .lastName("1")
                .build()
        );
    }
}

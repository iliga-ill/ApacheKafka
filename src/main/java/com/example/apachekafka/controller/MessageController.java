package com.example.apachekafka.controller;

import com.example.apachekafka.kafka.KafkaProducer;
import com.example.apachekafka.kafka.payload.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
//    private final JsonKafkaProducer jsonKafkaProducer;

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the string topic");
    }

    //http:localhost:8080/api/v1/kafka/publish/json
    @PostMapping("/publish/json")
    public ResponseEntity<String> publish(@RequestBody User message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the json topic");
    }


}

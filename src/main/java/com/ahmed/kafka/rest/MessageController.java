package com.ahmed.kafka.rest;

import com.ahmed.kafka.payload.Student;
import com.ahmed.kafka.producer.KafkaJsonProducer;
import com.ahmed.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendStudent(student);
        return ResponseEntity.ok("Student sent to kafka");
    }
}

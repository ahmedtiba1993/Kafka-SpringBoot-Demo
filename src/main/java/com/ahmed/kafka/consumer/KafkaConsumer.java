package com.ahmed.kafka.consumer;

import com.ahmed.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "topic1", groupId = "myGroup")
    public void consumeMsg(String topic) {
        log.info("consume msg topic:{}", topic);
    }

    @KafkaListener(topics = "topic2", groupId = "myGroup")
    public void consumeStudent(Student student) {
        log.info("consume student topic:{}", student);
    }
}

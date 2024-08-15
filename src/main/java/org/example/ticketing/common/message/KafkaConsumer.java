package org.example.ticketing.common.message;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private String message = null;

    @KafkaListener(topics = "reservation", groupId = "group01")
    public void listen(String message) {
        log.info("received message = {}", message);
        this.message = message;
        latch.countDown();

    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getMessage() {
        return message;
    }
}
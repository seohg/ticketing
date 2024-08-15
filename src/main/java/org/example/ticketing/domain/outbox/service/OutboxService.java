package org.example.ticketing.domain.outbox.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.domain.outbox.model.Outbox;
import org.example.ticketing.domain.outbox.model.OutboxStatus;
import org.example.ticketing.domain.outbox.model.Processed;
import org.example.ticketing.domain.outbox.repository.OutboxRepository;
import org.example.ticketing.domain.outbox.repository.ProcessedRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutboxService {

    private final OutboxRepository outboxRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ProcessedRepository processedRepository;

    @Scheduled(fixedRate = 5000)
    public void processOutboxMessages() {
        List<Outbox> messages = outboxRepository.findAllByStatus(OutboxStatus.INIT);

        for (Outbox message : messages) {
            String messageId = message.getId().toString();

            if (processedRepository.existsByMessageId(messageId)) {
                // 완료건 제외
                continue;
            }
            try {
                kafkaTemplate.send("payment", message.getMessage());

                message.complete();
                outboxRepository.save(message);

                Processed processedMessage = new Processed(messageId);
                processedRepository.save(processedMessage);

            } catch (Exception e) {
                message.fail();
                outboxRepository.save(message);

                e.printStackTrace();
            }

        }
    }
}
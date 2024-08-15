package org.example.ticketing.domain.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.domain.outbox.model.Outbox;
import org.example.ticketing.domain.outbox.model.Processed;
import org.example.ticketing.domain.outbox.repository.OutboxRepository;
import org.example.ticketing.domain.outbox.repository.ProcessedRepository;
import org.example.ticketing.domain.payment.client.DataPlatformMockApiClient;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;
import static org.springframework.transaction.event.TransactionPhase.BEFORE_COMMIT;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final OutboxRepository outboxRepository;
    private final ProcessedRepository processedRepository;

    @Async
    @TransactionalEventListener(phase = AFTER_COMMIT)
    public void sendOrderInfo(OrderPaidEvent orderPaidEvent) {

        try {
            String messageId = orderPaidEvent.getPayment().getId().toString();

            // 처리 여부 확인
            if (processedRepository.existsByMessageId(messageId)) { return; }

            //kafka event 전송
            String message = objectMapper.writeValueAsString(orderPaidEvent);
            kafkaTemplate.send("payment", message);

            // processed Table 저장
            Processed processed = new Processed(messageId);
            processedRepository.save(processed);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

package org.example.ticketing.domain.payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.domain.payment.client.DataPlatformMockApiClient;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final DataPlatformMockApiClient dataPlatformMockApiClient;

    @Async
    @TransactionalEventListener(phase = AFTER_COMMIT)
    public void sendOrderInfo(OrderPaidEvent orderPaidEvent) {
        try {
            dataPlatformMockApiClient.sendorder();
        } catch(Exception e) {
            log.error("주문정보전달에 실패했어요");
        }
    }
}

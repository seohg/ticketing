package org.example.ticketing.application.payment.useCase;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.outbox.model.Outbox;
import org.example.ticketing.domain.outbox.repository.OutboxRepository;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.service.OrderPaidEvent;
import org.example.ticketing.domain.payment.service.PaymentService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.example.ticketing.interfaces.presentation.payment.dto.PaymentResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class PaymentUseCase {
    private final ReservationService reservationService;
    private final UserService userService;
    private final PaymentService paymentService;
    private final ApplicationEventPublisher orderEventPublisher;
    private final ObjectMapper objectMapper;
    private final OutboxRepository outboxRepository;

    @Transactional
    public PaymentResponse pay(Long reservationId) {
        Reservation reservation = reservationService.getReservation(reservationId);
        User user = userService.getUser(reservation.getUser().getId());

        // 유저 포인트 차감
        user.pay(reservation.getPrice());

        // 주문 상태 변경
        reservation.complete();

        // 결제 정보 저장
        Payment payment = new Payment(reservation.getPrice(), reservation);
        paymentService.setPayment(payment);

        //outbox 저장
        OrderPaidEvent event = new OrderPaidEvent(payment);
        outboxRepository.save(new Outbox(event.toString()));

        //주문정보전송
        orderEventPublisher.publishEvent(new OrderPaidEvent(payment));

        return new PaymentResponse(payment.getId(), payment.getAmount(), payment.getStatus() );
    }
}

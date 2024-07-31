package org.example.ticketing.integration.payment;

import org.example.ticketing.application.payment.useCase.PaymentUseCase;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.model.PaymentStatus;
import org.example.ticketing.domain.payment.service.PaymentService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.model.ReservationStatus;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Transactional
public class PaymentUsecaseTest {
    @Autowired
    private PaymentUseCase paymentUseCase;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PaymentService paymentService;

    @Test
    @DisplayName("결제 처리 테스트")
    void processPaymentUseCaseTest() {
        // when
        paymentUseCase.pay(1L);
        Reservation reservation = reservationService.getReservation(1L);
        Payment payment = paymentService.getPayment(1L);


        // then
        assertThat(reservation.getStatus()).isEqualTo(ReservationStatus.COMPLETED);
        assertThat(payment.getStatus()).isEqualTo(PaymentStatus.COMPLETED);
    }
}

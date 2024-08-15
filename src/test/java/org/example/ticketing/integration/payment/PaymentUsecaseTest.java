package org.example.ticketing.integration.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ticketing.application.payment.useCase.PaymentUseCase;
import org.example.ticketing.common.message.KafkaConsumer;
import org.example.ticketing.common.message.KafkaProducer;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.model.PaymentStatus;
import org.example.ticketing.domain.payment.service.OrderEventListener;
import org.example.ticketing.domain.payment.service.OrderPaidEvent;
import org.example.ticketing.domain.payment.service.PaymentService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.model.ReservationStatus;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DirtiesContext
@RunWith(SpringRunner.class)
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@SpringBootTest
@Transactional
public class PaymentUsecaseTest {


    @Autowired
    private PaymentUseCase paymentUseCase;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PaymentService paymentService;

    @SpyBean
    private OrderEventListener orderEventListener;

    @Test
    @DisplayName("결제 처리 테스트")
    public void processPaymentUseCaseTest() {
        // when
        paymentUseCase.pay(1L);
        Reservation reservation = reservationService.getReservation(1L);
        Payment payment = paymentService.getPayment(1L);


        // then
        assertThat(reservation.getStatus()).isEqualTo(ReservationStatus.COMPLETED);
        assertThat(payment.getStatus()).isEqualTo(PaymentStatus.COMPLETED);
        verify(orderEventListener, times(1)).sendOrderInfo(any(OrderPaidEvent.class));
    }

}

package org.example.ticketing.domain.payment.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OrderEventPublisher {


   /* private final ApplicationEventPublisher publisher;

    public void publish(Payment payment) {
        OrderPaidEvent event = new OrderPaidEvent(payment);
        publisher.publishEvent(event);
    }

    */
}



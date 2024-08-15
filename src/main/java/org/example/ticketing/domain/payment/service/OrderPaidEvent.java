package org.example.ticketing.domain.payment.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Getter
public class OrderPaidEvent {
    private Payment payment;

    public OrderPaidEvent(Payment payment) {
        this.payment = payment;
    }
}
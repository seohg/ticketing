package org.example.ticketing.domain.payment.repository;

import org.example.ticketing.domain.payment.model.Payment;

public interface PaymentRepository {
    Payment setPayment(Payment payment);
}

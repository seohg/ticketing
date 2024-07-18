package org.example.ticketing.domain.payment.repository;

import org.example.ticketing.domain.payment.model.Payment;

import java.util.Optional;

public interface PaymentRepository {
    Payment setPayment(Payment payment);

    Optional<Payment> getPayment(Long paymentId);
}

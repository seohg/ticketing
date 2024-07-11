package org.example.ticketing.domain.payment.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.example.ticketing.domain.payment.model.Payment;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void setPayment(Payment payment) {
        paymentRepository.setPayment(payment);
    }
}

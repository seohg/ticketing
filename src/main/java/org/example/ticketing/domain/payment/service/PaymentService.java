package org.example.ticketing.domain.payment.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    public void setPayment(Payment payment) {
        paymentRepository.setPayment(payment);
    }

    public Payment getPayment(Long paymentId) {
        return paymentRepository.getPayment(paymentId);
    }
}

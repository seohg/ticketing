package org.example.ticketing.infra.payments;

import com.querydsl.jpa.JPQLQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.repository.PaymentRepository;
import org.example.ticketing.infra.payments.mapper.PaymentMapper;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment setPayment(Payment payment) {
        return PaymentMapper.toDomain(paymentJpaRepository.save(PaymentMapper.toEntity(payment)));
    }
    @Override
    public Payment getPayment(Long paymentId) {
        return PaymentMapper.toDomain(paymentJpaRepository.findById(paymentId).orElseThrow(EntityNotFoundException::new));
    }
}


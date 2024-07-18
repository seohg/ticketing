package org.example.ticketing.infra.payments;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.repository.PaymentRepository;
import org.example.ticketing.infra.concert.ConcertJpaRepository;
import org.example.ticketing.infra.concert.SeatJpaRepository;
import org.example.ticketing.infra.reservation.ReservationJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.example.ticketing.domain.payment.model.QPayment.payment;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final JPQLQueryFactory queryFactory;

    @Override
    public Payment setPayment(Payment payment) {
        return paymentJpaRepository.save(payment);
    }
    @Override
    public Optional<Payment> getPayment(Long paymentId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(payment)
                        .where(payment.id.eq(paymentId))
                        .fetchOne());
    }
}


package org.example.ticketing.infra.payments.mapper;

import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.infra.payments.entity.PaymentEntity;
import org.example.ticketing.infra.reservation.mapper.ReservationMapper;

public class PaymentMapper {
    public static Payment toDomain(PaymentEntity paymentEntity) {
        return new Payment(paymentEntity.getId(), paymentEntity.getAmount(),paymentEntity.getStatus(), ReservationMapper.toDomain(paymentEntity.getReservationEntity()));
    }

    public static PaymentEntity toEntity(Payment payment) {
        return new PaymentEntity(payment.getId(), payment.getAmount(), payment.getStatus(), ReservationMapper.toEntity(payment.getReservation()));
    }
}

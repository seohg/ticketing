package org.example.ticketing.infra.payments;

import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.infra.payments.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {

}
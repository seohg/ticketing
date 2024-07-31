package org.example.ticketing.infra.payments.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.payment.model.PaymentStatus;
import org.example.ticketing.infra.reservation.entity.ReservationEntity;

@Entity
@Table(name = "payments")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservationEntity;

    private PaymentEntity(Integer amount, PaymentStatus status, ReservationEntity reservationEntity) {
        this.amount = amount;
        this.status = status;
        this.reservationEntity = reservationEntity;
    }


}
package org.example.ticketing.domain.payment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.reservation.model.Reservation;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private Integer amount;
    private PaymentStatus status;
    private Reservation reservation;

    private Payment(Integer amount, PaymentStatus status, Reservation reservation) {
        this.amount = amount;
        this.status = status;
        this.reservation = reservation;
    }
    public Payment(Integer amount, Reservation reservation) {
        this.amount = amount;
        this.reservation = reservation;
    }

}
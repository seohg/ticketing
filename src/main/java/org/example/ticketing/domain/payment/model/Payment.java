package org.example.ticketing.domain.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.reservation.model.Reservation;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@Getter
public class Payment {
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
    private Reservation reservation;

    private Payment(Integer amount, PaymentStatus status, Reservation reservation) {
        this.amount = amount;
        this.status = status;
        this.reservation = reservation;
    }

    public static Payment create(Integer amount, Reservation reservation) {
        return new Payment(amount, PaymentStatus.COMPLETED, reservation);
    }
}
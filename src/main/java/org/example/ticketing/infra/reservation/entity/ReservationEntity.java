package org.example.ticketing.infra.reservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.reservation.model.ReservationStatus;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.infra.user.entity.UserEntity;
import org.example.ticketing.infra.concert.entity.SeatEntity;

@Entity
@Table(name = "reservations")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private ReservationEntity(SeatEntity seatEntity, UserEntity userEntity) {
        this.status = ReservationStatus.ONGOING;
        this.price = seatEntity.getPrice();
        this.seatEntity = seatEntity;
        this.userEntity = userEntity;
    }
    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }
}
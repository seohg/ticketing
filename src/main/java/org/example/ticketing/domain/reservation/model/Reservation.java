package org.example.ticketing.domain.reservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.user.model.User;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long id;
    private ReservationStatus status;
    private Integer price;
    private Seat seat;
    private User user;

    private Reservation(Seat seat, User user) {
        this.status = ReservationStatus.ONGOING;
        this.price = seat.getPrice();
        this.seat = seat;
        this.user = user;
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }
}
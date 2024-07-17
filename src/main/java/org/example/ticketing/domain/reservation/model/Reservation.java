package org.example.ticketing.domain.reservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.user.model.User;

@Entity
@Table(name = "reservation")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
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
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Reservation(Seat seat, User user) {
        this.status = ReservationStatus.ONGOING;
        this.price = seat.getPrice();
        this.seat = seat;
        this.user = user;
    }

    public static Reservation create(Seat seat, User user) {
        return new Reservation(seat, user);
    }



    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }
}
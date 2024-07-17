package org.example.ticketing.domain.concert.model;


import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.token.model.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "seat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "price")
    private Integer price;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "hold_time")
    private LocalDateTime holdTime;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    private Seat(Long number, Integer price, SeatStatus status, LocalDateTime holdTime, Show show) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.holdTime = holdTime;
        this.show = show;
    }

    public static Seat create(Long number, Integer price, Show show) {
        return new Seat(number, price, SeatStatus.EMPTY, null, show);
    }

    public void holdSeat() {
        this.status = SeatStatus.HOLD;
        this.holdTime = LocalDateTime.now().plusMinutes(5);
    }

    public boolean isEmpty() {
        return this.status == SeatStatus.EMPTY;
    }

    public void checkIsValid() {
        if (!isEmpty()) {
            throw new BaseException(ErrorMessage.OCCUPIED_SEAT);
        }
    }
    public void SetEmptyIfTimeExpired() {
        if (holdTime.isBefore(LocalDateTime.now())) {
            setStatus(SeatStatus.EMPTY);
        }
    }
}
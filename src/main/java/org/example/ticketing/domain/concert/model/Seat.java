package org.example.ticketing.domain.concert.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private Long id;
    private Long number;
    private Integer price;
    private SeatStatus status;
    private LocalDateTime holdTime;
    private Show show;

    private Seat(Long number, Integer price, SeatStatus status, LocalDateTime holdTime, Show show) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.holdTime = holdTime;
        this.show = show;
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
            this.status = SeatStatus.EMPTY;
        }
    }
}
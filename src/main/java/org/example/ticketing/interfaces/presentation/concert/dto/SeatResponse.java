package org.example.ticketing.interfaces.concert.dto;

import lombok.Getter;
import org.example.ticketing.domain.concert.model.Seat;

@Getter
public class SeatResponse {

    private long seatId;
    private long seatNumber;

    public SeatResponse(long seatId, long seatNumber) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
    }

    public static SeatResponse from(Seat seat) {
        return new SeatResponse(seat.getId(), seat.getNumber());
    }
}
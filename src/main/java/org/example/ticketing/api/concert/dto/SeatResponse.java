package org.example.ticketing.api.concert.dto;

import lombok.Getter;

@Getter
public class SeatResponse {

    private long seatId;
    private long seatNumber;

    public SeatResponse(long seatId, long seatNumber) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
    }
}
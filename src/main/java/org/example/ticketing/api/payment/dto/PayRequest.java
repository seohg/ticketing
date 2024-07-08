package org.example.ticketing.api.payment.dto;

import lombok.Getter;

@Getter
public class PayRequest {
    private long showId;
    private long seatId;
}

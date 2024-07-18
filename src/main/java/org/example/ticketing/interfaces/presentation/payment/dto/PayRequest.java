package org.example.ticketing.interfaces.presentation.payment.dto;

import lombok.Getter;

@Getter
public class PayRequest {
    private long showId;
    private long seatId;
}

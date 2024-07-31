package org.example.ticketing.interfaces.presentation.reservation.dto;

import lombok.Getter;
import org.example.ticketing.domain.reservation.model.ReservationStatus;

@Getter
public class ReservationResponse {

    private Long reservationId;
    private ReservationStatus reservationStatus;
    private Integer price;

    public ReservationResponse(Long reservationId, ReservationStatus reservationStatus, Integer price) {
        this.reservationId = reservationId;
        this.reservationStatus = reservationStatus;
        this.price = price;
    }
}
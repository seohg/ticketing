package org.example.ticketing.domain.reservation.service;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public Reservation reserve(Reservation reservation) {
        return reservationRepository.reserve(reservation);
    }

    public Reservation getReservation(Long reservationId) {
        return reservationRepository.getReservation(reservationId)
                .orElseThrow(() -> new BaseException(ErrorMessage.RESERVATION_NOT_FOUND));
    }
}
package org.example.ticketing.domain.reservation.repository;

import org.example.ticketing.domain.reservation.model.Reservation;

import java.util.Optional;

public interface ReservationRepository {
    Reservation reserve(Reservation reservation);
    Optional<Reservation> getReservation(Long reservationId);
}

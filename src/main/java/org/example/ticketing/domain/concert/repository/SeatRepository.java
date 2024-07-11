package org.example.ticketing.domain.concert.repository;

import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.model.Show;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SeatRepository {
    List<Seat> getSeatsByShowIdAndShowStatus(Long showId, SeatStatus status);

    Optional<Seat> getSeat(Long seatId);

    Seat setSeat(Seat seat);

    List<Seat> getSeatsByStatus(SeatStatus status);
}

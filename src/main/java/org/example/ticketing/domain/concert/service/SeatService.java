package org.example.ticketing.domain.concert.service;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
        //@Transactional(readOnly = true)
public class SeatService {
    private final SeatRepository seatRepository;

    public List<Seat> getEmptySeats(Long showId) {
        return seatRepository.getSeatsByShowIdAndShowStatus(showId, SeatStatus.EMPTY);
    }

    public Seat getSeat(Long seatId) {
        return seatRepository.getSeat(seatId);
    }

    public void setSeat(Seat seat) {
        seatRepository.setSeat(seat);
    }

    public List<Seat> getHoldSeats() {
        return seatRepository.getSeatsByStatus(SeatStatus.HOLD);
    }

}

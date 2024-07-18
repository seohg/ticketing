package org.example.ticketing.interfaces.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.domain.concert.service.SeatService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.example.ticketing.domain.concert.model.Seat;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SeatSchedule {
    private final SeatService seatService;

    @Scheduled(fixedRate = 10000)
    public void seatSchedule() {
        seatService.getHoldSeats().forEach(Seat::SetEmptyIfTimeExpired);
    }
}
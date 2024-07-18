package org.example.ticketing.integration.reservation;


import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.service.SeatService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.ticketing.application.concert.ReservationUsecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class ReservationUsecaseTest {
    @Autowired
    private ReservationUsecase reservationUsecase;

    @Autowired
    private SeatService seatService;
    @Test
    @DisplayName("좌석 예약 테스트")
    void reserveSeatUseCaseTest() {
        // when
        reservationUsecase.reserve("token", 1L);
        Seat seat = seatService.getSeat(1L);

        // then
        assertThat(seat.getStatus()).isEqualTo(SeatStatus.HOLD);
    }
}

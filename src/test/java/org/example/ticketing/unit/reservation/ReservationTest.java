package org.example.ticketing.unit.reservation;

import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.model.ReservationStatus;
import org.example.ticketing.domain.reservation.repository.ReservationRepository;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.example.ticketing.domain.user.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Test
    @DisplayName("예약 테스트")
    void reservationTest() {
        // given
        User user = User.builder().id(1L).name("user1").balance(100000L).build();
        Concert concert = Concert.builder().id(1L).name("concert1").build();
        Show show = Show.builder().id(1L).date(LocalDateTime.now()).capacity(10).concert(concert).build();
        Seat seat = Seat.builder().id(1L).number(10L).price(10000).status(SeatStatus.EMPTY).holdTime(LocalDateTime.now()).show(show).build();
        Reservation reservation = Reservation.builder().id(1L).status(ReservationStatus.ONGOING).price(1000).seat(seat).user(user).build();

        when(reservationRepository.reserve(reservation)).thenReturn(reservation);
        // when
        reservationService.reserve(reservation);

        // then
        verify(reservationRepository, times(1)).reserve(any());
    }


}

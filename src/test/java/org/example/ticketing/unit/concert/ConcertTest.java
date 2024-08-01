package org.example.ticketing.unit.concert;

import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.repository.SeatRepository;
import org.example.ticketing.domain.concert.repository.ShowRepository;
import org.example.ticketing.domain.concert.service.SeatService;
import org.example.ticketing.domain.concert.service.ShowService;
import org.example.ticketing.domain.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ConcertTest {
    @InjectMocks
    private SeatService seatService;
    @InjectMocks
    private ShowService showService;

    @Mock
    private SeatRepository seatRepository;
    @Mock
    private ShowRepository showRepository;

    @Test
    @DisplayName("좌석 조회 성공 테스트")
    void getSeatSuccessTest() {
        // given
        Long seatId = 1L;

        // when
        when(seatRepository.getSeat(anyLong())).thenReturn(new Seat());

        // then
        assertNotNull(seatService.getSeat(seatId));
    }
    @Test
    @DisplayName("좌석리스트 조회 테스트")
    void getSeatListSuccessTest() {
        // given
        User user = User.builder().id(1L).name("user1").balance(100000L).build();
        Concert concert = Concert.builder().id(1L).name("concert1").build();
        Show show = Show.builder().id(1L).date(LocalDateTime.now()).capacity(10).concert(concert).build();
        Seat seat1 = Seat.builder().id(1L).number(10L).price(10000).status(SeatStatus.EMPTY).holdTime(LocalDateTime.now()).show(show).build();
        Seat seat2 = Seat.builder().id(1L).number(10L).price(10000).status(SeatStatus.EMPTY).holdTime(LocalDateTime.now()).show(show).build();

        List<Seat> seats = new ArrayList<>(2);
        seats.add(seat1);
        seats.add(seat2);


        // when
        when(seatRepository.getSeatsByShowIdAndShowStatus(anyLong(), any())).thenReturn(seats);

        // then
        assertNotNull(seatService.getEmptySeats(1L));
    }
    @Test
    @DisplayName("좌석 조회 실패(미존재) 테스트")
    void getSeatFailTest() {
        // given
        Long seatId = 10L;

        // when
        when(seatRepository.getSeat(anyLong())).thenReturn(null);

        // then
        assertThatThrownBy(() -> seatService.getSeat(seatId))
                .isInstanceOf(BaseException.class);
    }

    @Test
    @DisplayName("좌석 5분후 만료 테스트")
    void setEmptyafter5minutesSuccessTest() {
        Concert concert = Concert.builder().id(1L).name("concert1").build();
        Show show = Show.builder().id(1L).date(LocalDateTime.now()).capacity(10).concert(concert).build();
       // Seat seat = new Seat(1L, 5000, show);
      //  seat.holdSeat();
        //seat.setHoldTime(seat.getHoldTime().minusMinutes(6));
      //  seat.SetEmptyIfTimeExpired();

      //  Assertions.assertEquals(SeatStatus.EMPTY, seat.getStatus());
    }
    @Test
    @DisplayName("공연리스트 테스트")
    void getShowListTest() {
        Concert concert = Concert.builder().id(1L).name("concert1").build();
        Show show1 = Show.builder().id(1L).date(LocalDateTime.now()).capacity(10).concert(concert).build();
        Show show2 = Show.builder().id(2L).date(LocalDateTime.now()).capacity(20).concert(concert).build();
        List<Show> shows = new ArrayList<>(2);
        shows.add(show1);
        shows.add(show2);

        // given
        Long showId = 1L;

        // when
        when(showRepository.getShows(1L,LocalDateTime.now())).thenReturn(shows);

        // then
        assertNotNull(showService.getShows(showId));
    }


}

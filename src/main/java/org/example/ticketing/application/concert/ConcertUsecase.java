package org.example.ticketing.application.concert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.interfaces.presentation.concert.dto.SeatResponse;
import org.example.ticketing.interfaces.presentation.concert.dto.ShowDateResponse;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.service.ConcertService;
import org.example.ticketing.domain.concert.service.SeatService;
import org.springframework.stereotype.Component;
import org.example.ticketing.domain.concert.service.ShowService;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ConcertUsecase{
    private final ShowService showService;
    private final SeatService seatService;
    private final ConcertService concertService;
    public List<ShowDateResponse> getShowDate(Long concertId) {
        List<Show> shows = showService.getShows(concertId);
        return shows.stream().map(ShowDateResponse::from).toList();
    }

    public List<SeatResponse> getSeatList(Long showId) {
        List<Seat> emptySeats = seatService.getEmptySeats(showId);
        return emptySeats.stream().map(SeatResponse::from).toList();
    }


}

package org.example.ticketing.domain.concert.repository;

import org.example.ticketing.domain.concert.model.Show;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertRepository {
    List<Show> getShows(Long concertId, LocalDateTime now);
}

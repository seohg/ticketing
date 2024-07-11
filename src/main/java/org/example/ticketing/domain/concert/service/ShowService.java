package org.example.ticketing.domain.concert.service;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.repository.ShowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowService {
    private final ShowRepository showRepository;
    public List<Show> getShows(Long concertId) {
        LocalDateTime now = LocalDateTime.now();
        return showRepository.getShows(concertId, now);
    }

}

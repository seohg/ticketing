package org.example.ticketing.domain.concert.service;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.concert.repository.ConcertRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertService {
    private final ConcertRepository concertRepository;


}

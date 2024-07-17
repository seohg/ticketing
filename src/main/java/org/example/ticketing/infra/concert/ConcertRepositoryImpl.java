package org.example.ticketing.infra.concert;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.repository.ConcertRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.example.ticketing.domain.concert.model.QConcert.concert;
import static org.example.ticketing.domain.concert.model.QShow.show;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepository {
    private final JPQLQueryFactory queryFactory;

    @Override
    public List<Show> getShows(Long concertId, LocalDateTime now) {
        return queryFactory.selectFrom(show)
                .join(show.concert, concert)
                .where(concert.id.eq(concertId), show.date.gt(now))
                .fetch();
    }
}


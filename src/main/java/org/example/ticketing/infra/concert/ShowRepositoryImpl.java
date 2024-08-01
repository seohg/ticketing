package org.example.ticketing.infra.concert;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.repository.ShowRepository;
import org.example.ticketing.infra.concert.entity.QConcertEntity;
import org.example.ticketing.infra.concert.entity.QShowEntity;
import org.example.ticketing.infra.concert.mapper.ShowMapper;
import org.example.ticketing.infra.token.mapper.TokenMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.example.ticketing.infra.concert.entity.QConcertEntity.concertEntity;
import static org.example.ticketing.infra.concert.entity.QShowEntity.showEntity;


@Repository
@RequiredArgsConstructor
public class ShowRepositoryImpl implements ShowRepository {
    private final JPQLQueryFactory queryFactory;

    @Override
    public List<Show> getShows(Long concertId, LocalDateTime now) {
        return queryFactory.selectFrom(showEntity)
                .join(showEntity.concert, concertEntity)
                .where(concertEntity.id.eq(concertId), showEntity.date.gt(now))
                .fetch().stream().map(ShowMapper::toDomain).toList();
    }
}


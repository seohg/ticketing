package org.example.ticketing.infra.concert;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.domain.concert.repository.SeatRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.example.ticketing.domain.concert.model.QSeat.seat;
import static org.example.ticketing.domain.concert.model.QShow.show;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {
    private final SeatJpaRepository seatJpaRepository;
    private final JPQLQueryFactory queryFactory;

    @Override
    public List<Seat> getSeatsByShowIdAndShowStatus(Long showId, SeatStatus status) {
        return queryFactory.selectFrom(seat)
                .join(seat.show, show)
                .where(show.id.eq(showId), seat.status.eq(status))
                .fetch();
    }

    @Override
    public Optional<Seat> getSeat(Long seatId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(seat)
                        .where(seat.id.eq(seatId))
                        .fetchOne());
    }

    @Override
    public Seat setSeat(Seat seat) {
        return seatJpaRepository.save(seat);
    }

    @Override
    public List<Seat> getSeatsByStatus(SeatStatus status) {
        return queryFactory.selectFrom(seat)
                .where(seat.status.eq(status))
                .fetch();
    }
}


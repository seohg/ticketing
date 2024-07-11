package org.example.ticketing.infra.reservation;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.repository.ReservationRepository;
import org.example.ticketing.infra.concert.ConcertJpaRepository;
import org.example.ticketing.infra.concert.SeatJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.example.ticketing.domain.reservation.model.QReservation.reservation;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
    private final ReservationJpaRepository reservationJpaRepository;
    private final JPQLQueryFactory queryFactory;


    @Override
    public Reservation reserve(Reservation reservation) {
        return reservationJpaRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservation(Long reservationId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(reservation)
                        .where(reservation.id.eq(reservationId))
                        .fetchOne());
    }
}


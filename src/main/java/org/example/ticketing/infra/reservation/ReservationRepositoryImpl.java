package org.example.ticketing.infra.reservation;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.repository.ReservationRepository;
import org.example.ticketing.infra.reservation.mapper.ReservationMapper;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
    private final ReservationJpaRepository reservationJpaRepository;


    @Override
    public Reservation reserve(Reservation reservation) {
        return ReservationMapper.toDomain(reservationJpaRepository.save(ReservationMapper.toEntity(reservation)));
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        return ReservationMapper.toDomain(reservationJpaRepository.pessimisticFindReservationById(reservationId).orElseThrow(EntityNotFoundException::new));
    }
}


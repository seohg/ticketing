package org.example.ticketing.infra.reservation;

import jakarta.persistence.LockModeType;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.infra.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM ReservationEntity r WHERE r.id = :reservationId")
    Optional<ReservationEntity> pessimisticFindReservationById(@Param("reservationId") Long reservationId);

}
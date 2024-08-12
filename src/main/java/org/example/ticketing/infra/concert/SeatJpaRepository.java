package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.infra.concert.entity.SeatEntity;
import org.example.ticketing.infra.concert.mapper.SeatMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.example.ticketing.infra.concert.entity.QSeatEntity.seatEntity;
import static org.example.ticketing.infra.concert.entity.QShowEntity.showEntity;

public interface SeatJpaRepository extends JpaRepository<SeatEntity, Long> {
    @Query(value = "SELECT s FROM SeatEntity s JOIN FETCH s.showEntity WHERE s.showEntity.id = :showId AND s.status = :status",
            countQuery = "SELECT COUNT(s) FROM SeatEntity s INNER JOIN s.showEntity WHERE s.showEntity.id = :showId AND s.status = :status")
    List<SeatEntity> getSeatsByShowIdAndShowStatus(@Param("showId") Long showId, @Param("status")  SeatStatus status) ;
}

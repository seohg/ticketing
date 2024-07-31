package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.infra.concert.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatJpaRepository extends JpaRepository<SeatEntity, Long> {

}
package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatJpaRepository extends JpaRepository<Seat, Long> {
}
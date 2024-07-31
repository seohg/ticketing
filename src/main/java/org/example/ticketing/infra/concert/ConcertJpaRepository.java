package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.infra.concert.entity.ConcertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertJpaRepository extends JpaRepository<ConcertEntity, Long> {
}
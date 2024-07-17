package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertJpaRepository extends JpaRepository<Concert, Long> {
}
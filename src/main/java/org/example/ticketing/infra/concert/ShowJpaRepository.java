package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowJpaRepository extends JpaRepository<Show, Long> {
}
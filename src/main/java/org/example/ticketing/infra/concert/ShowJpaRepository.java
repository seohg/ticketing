package org.example.ticketing.infra.concert;

import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.infra.concert.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowJpaRepository extends JpaRepository<ShowEntity, Long> {
}
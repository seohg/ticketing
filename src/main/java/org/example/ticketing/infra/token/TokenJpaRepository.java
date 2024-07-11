package org.example.ticketing.infra.token;

import org.example.ticketing.domain.token.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<Token, Long> {
}
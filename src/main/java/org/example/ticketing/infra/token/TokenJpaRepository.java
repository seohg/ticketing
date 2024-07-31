package org.example.ticketing.infra.token;

import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.infra.token.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, Long> {
    Optional<TokenEntity> findByToken(String token);

    @Query("SELECT a FROM TokenEntity a WHERE a.status <> :status ORDER BY a.id ASC")
    List<TokenEntity> findAllByExpiredTime(Status status);

    @Query("SELECT a FROM TokenEntity a WHERE a.id = :userId AND a.status <> 'EXPIRED' ORDER BY a.id ASC")
    Optional<TokenEntity> findAllByUserIdAndStatus(Long userId);

}
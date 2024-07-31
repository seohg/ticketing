package org.example.ticketing.infra.user;

import jakarta.persistence.LockModeType;
import org.example.ticketing.infra.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM UserEntity a WHERE a.id = :userId")
    Optional<UserEntity> pessimisticFindById(@Param("userId") Long userId);
}

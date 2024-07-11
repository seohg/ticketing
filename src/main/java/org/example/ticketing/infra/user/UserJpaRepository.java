package org.example.ticketing.infra.user;

import org.example.ticketing.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}

package org.example.ticketing.domain.user.repository;

import org.example.ticketing.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUser(Long userId);
    User setUser(User user);
}

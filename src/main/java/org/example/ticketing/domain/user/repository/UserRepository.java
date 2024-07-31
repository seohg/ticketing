package org.example.ticketing.domain.user.repository;

import org.example.ticketing.domain.user.model.User;

import java.util.Optional;

public interface UserRepository {
    User findUserById(Long userId) ;
    User pessimisticFindUserById(Long userId);
    User save(User user);

}

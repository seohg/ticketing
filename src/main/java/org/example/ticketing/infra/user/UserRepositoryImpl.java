package org.example.ticketing.infra.user;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> getUser(Long userId) {
        return userJpaRepository.findById(userId);
    }

    @Override
    public User setUser(User user) {
        return userJpaRepository.save(user);
    }

}
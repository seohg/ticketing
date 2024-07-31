package org.example.ticketing.infra.user;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.repository.UserRepository;
import org.example.ticketing.infra.user.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User findUserById(Long userId) {
        return UserMapper.toDomain(userJpaRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public User pessimisticFindUserById(Long userId) {
        return UserMapper.toDomain(userJpaRepository.pessimisticFindById(userId).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public User save(User user) {
        return UserMapper.toDomain(userJpaRepository.save(UserMapper.toEntity(user)));
    }



}
package org.example.ticketing.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findUserById(userId);
    }

    public User pessimisticGetUser(Long userId) {
        return userRepository.pessimisticFindUserById(userId);
    }
    public User chargeBalance(User user, Long amount) {
        return userRepository.save(user.chargeBalance(amount));
    }

}

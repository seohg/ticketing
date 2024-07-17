package org.example.ticketing.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.getUser(userId).orElseThrow(() -> new BaseException(ErrorMessage.USER_NOT_FOUND));
    }
    public void setUser(User user) {
        userRepository.setUser(user);
    }

}

package org.example.ticketing.application.user;

import org.example.ticketing.interfaces.presentation.user.dto.UserBalanceRequest;
import org.example.ticketing.interfaces.presentation.user.dto.UserBalanceResponse;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class UserBalanceUseCase {
    private final UserService userService;
    public UserBalanceResponse getUserBalance(Long userId) {
        User user = userService.getUser(userId);
        return UserBalanceResponse.from(user.getBalance());
    }

    public void chargeUserBalance(Long userId, UserBalanceRequest userBalanceRequest) {
        User user = userService.getUser(userId);
        user.chargeBalance(userBalanceRequest.getAmount());
        userService.setUser(user);
    }

}

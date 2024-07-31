package org.example.ticketing.application.user.useCase;

import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserBalanceUseCase {
    private final UserService userService;
    public Long getUserBalance(Long userId) {
        User user = userService.getUser(userId);
        return user.getBalance();
    }

    @Transactional
    public Long chargeUserBalance(Long userId, Long amount) {
        User user = userService.pessimisticGetUser(userId);
        userService.chargeBalance(user, amount);
        return user.getBalance();
    }

}

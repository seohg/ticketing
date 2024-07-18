package org.example.ticketing.interfaces.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserBalanceResponse {
    private Long balance;

    public UserBalanceResponse(Long balance) {
        this.balance = balance;
    }

    public static UserBalanceResponse from(Long balance) {
        return new UserBalanceResponse(balance);
    }
}
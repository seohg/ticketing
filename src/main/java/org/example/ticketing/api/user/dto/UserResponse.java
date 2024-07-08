package org.example.ticketing.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {
    private Long balance;

    public UserResponse(Long balance) {
        this.balance = balance;
    }
}
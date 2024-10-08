package org.example.ticketing.interfaces.presentation.token.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.domain.token.model.Status;

@Getter
@NoArgsConstructor
public class TokenResponse {
    private String token;
    private Status status;
    private long waitNumber;

    public TokenResponse(String token, Status status, long waitNumber) {
        this.token = token;
        this.status = status;
        this.waitNumber = waitNumber;
    }
}
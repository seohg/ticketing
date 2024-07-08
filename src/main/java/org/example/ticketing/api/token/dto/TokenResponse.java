package org.example.ticketing.api.token.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

}
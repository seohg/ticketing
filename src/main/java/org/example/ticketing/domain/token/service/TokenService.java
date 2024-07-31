package org.example.ticketing.domain.token.service;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.repository.TokenRepository;
import org.example.ticketing.infra.token.TokenJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;
    private final TokenJpaRepository tokenJpaRepository;
    public boolean isExistToken(Long userId) {
        return tokenRepository.getTokenByUserId(userId) != null;
    }

    public List<Token> getUnexpiredTokens(Status status) {
        return tokenRepository.getUnexpiredWaitTokens(status);
    }

    public void addToken(Token token) {
        tokenRepository.addToken(token);
    }

    public Token getTokenByUserId(Long userId) {
        return tokenRepository.getTokenByUserId(userId);
    }
    public Token getTokenByToken(String token) {
        return tokenRepository.getTokenByToken(token);
    }

}

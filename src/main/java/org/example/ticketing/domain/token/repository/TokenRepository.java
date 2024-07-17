package org.example.ticketing.domain.token.repository;

import org.example.ticketing.domain.token.model.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository {
    Optional<Token> getTokenByUserId(Long userId);
    List<Token> getUnexpiredWaitTokens();
    Token addToken(Token token);
    Optional<Token> getTokenByToken(String token);

}

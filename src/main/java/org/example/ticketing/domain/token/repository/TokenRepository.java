package org.example.ticketing.domain.token.repository;

import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.domain.token.model.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository {
    Token getTokenByUserId(Long userId);
    List<Token> getUnexpiredWaitTokens(Status status) ;
    Token addToken(Token token);
    Token getTokenByToken(String token);

}

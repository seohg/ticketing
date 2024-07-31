package org.example.ticketing.infra.token;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.repository.TokenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.example.ticketing.infra.token.mapper.TokenMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {
    private final TokenJpaRepository tokenJpaRepository;

    @Override
    public Token getTokenByUserId(Long userId) {
        return TokenMapper.toDomain(tokenJpaRepository.findAllByUserIdAndStatus(userId).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Token> getUnexpiredWaitTokens(Status status) {
        return tokenJpaRepository.findAllByExpiredTime(status).stream().map(TokenMapper::toDomain).toList();
    }

    @Override
    public Token addToken(Token token) {
        return TokenMapper.toDomain(tokenJpaRepository.save(TokenMapper.toEntity(token)));
    }

    @Override
    public Token getTokenByToken(String token) {
        return TokenMapper.toDomain(tokenJpaRepository.findByToken(token).orElseThrow(EntityNotFoundException::new));

    }
}

package org.example.ticketing.infra.token;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.repository.TokenRepository;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.JPQLQueryFactory;

import java.util.List;
import java.util.Optional;

import static org.example.ticketing.domain.token.model.QToken.token1;


@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {
    private final TokenJpaRepository tokenJpaRepository;
    private final JPQLQueryFactory queryFactory;

    @Override
    public Optional<Token> getTokenByUserId(Long userId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(token1)
                        .where(
                                token1.user.id.eq(userId),
                                token1.status.ne(Status.EXPIRED)
                        )
                        .fetchOne());
    }

    @Override
    public List<Token> getUnexpiredWaitTokens() {
        return queryFactory.selectFrom(token1)
                .where(token1.status.ne(Status.EXPIRED))
                .fetch();
    }

    @Override
    public Token addToken(Token token) {
        return tokenJpaRepository.save(token);
    }

    @Override
    public Optional<Token> getTokenByToken(String token) {
        return Optional.ofNullable(
                queryFactory.selectFrom(token1)
                        .where(
                                token1.token.eq(token),
                                token1.status.ne(Status.EXPIRED)
                        )
                        .fetchOne());
    }
}

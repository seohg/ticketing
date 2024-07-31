package org.example.ticketing.infra.token.mapper;

import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.infra.token.entity.TokenEntity;
import org.example.ticketing.infra.user.mapper.UserMapper;

public class TokenMapper {
    public static Token toDomain(TokenEntity tokenEntity) {
        return new Token(tokenEntity.getId(), tokenEntity.getToken(), tokenEntity.getAccessTime(), tokenEntity.getExpirationTime(), tokenEntity.getStatus(), UserMapper.toDomain(tokenEntity.getUserEntity()));
    }

    public static TokenEntity toEntity(Token token) {
        return new TokenEntity(token.getId(), token.getToken(), token.getAccessTime(), token.getExpirationTime(), token.getStatus(),UserMapper.toEntity(token.getUser()));
    }
}

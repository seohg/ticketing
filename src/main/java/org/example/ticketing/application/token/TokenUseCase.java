package org.example.ticketing.interfaces.presentation.token;

import org.example.ticketing.interfaces.presentation.token.dto.TokenResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.service.TokenService;
import org.example.ticketing.domain.user.model.User;
import org.springframework.stereotype.Component;
import org.example.ticketing.domain.user.service.UserService;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class TokenUseCase {
    private final UserService userService;
    private final TokenService tokenService;
    public TokenResponse issueToken(Long userId) {

        User user = userService.getUser(userId);
        String tokenStr = UUID.randomUUID().toString();

        // 유저 토큰 존재 여부 확인
        if (tokenService.isExistToken(userId)) {
            throw new BaseException(ErrorMessage.EXIST_TOKEN);
        }

        // 진행 + 대기중 토큰 확인
        List<Token> unexpiredTokens = tokenService.getUnexpiredTokens();

        long ongoingNumber = unexpiredTokens.stream()
                .filter(Token::isOngoing)
                .count();

        // 토큰 생성
        Token token = Token.create(tokenStr, ongoingNumber, user);
        tokenService.addToken(token);

        // 대기열 확인
        long waitNumber = token.getWaitingNumber(unexpiredTokens.size(), ongoingNumber);

        return TokenResponse.of(tokenStr, token.getStatus(), waitNumber);
    }

    public TokenResponse getToken(Long userId) {
        Token token = tokenService.getTokenByUserId(userId);

        // 진행 + 대기중 토큰 확인
        List<Token> unexpiredTokens = tokenService.getUnexpiredTokens();

        long ongoingNumber = unexpiredTokens.stream()
                .filter(Token::isOngoing)
                .count();

        // 대기열 확인
        long waitNumber = token.getWaitingNumber(unexpiredTokens.size(), ongoingNumber);

        return TokenResponse.of(token.getToken(), token.getStatus(), waitNumber);
    }

}

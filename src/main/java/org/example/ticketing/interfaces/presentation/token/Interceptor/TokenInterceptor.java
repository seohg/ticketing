package org.example.ticketing.interfaces.presentation.token.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    private final TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Token 유효성 체크");

        String tokenStr = request.getHeader("Authorization");
        Token token = tokenService.getTokenByToken(tokenStr);

        token.validateToken();
        token.plusValidTime();
        return true;
    }
}
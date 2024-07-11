package org.example.ticketing;


import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.repository.TokenRepository;
import org.example.ticketing.domain.token.service.TokenService;
import org.example.ticketing.domain.user.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TokenTest {
    @InjectMocks
    private TokenService tokenService;

    @Mock
    private TokenRepository tokenRepository;

    @Test
    @DisplayName("토큰 조회 테스트1")
    void getTokenSuccessTest() {
        // given
        String tokenStr = "tokenStr";
        User user = User.builder().id(1L).name("user1").balance(100000L).build();
        Token token = new Token();
        token.create(tokenStr, 1, user);

        // when
        when(tokenRepository.getTokenByToken(tokenStr)).thenReturn(Optional.of(token));

        // then
        assertThat(tokenService.getTokenByToken(tokenStr)).isEqualTo(token);
    }

    @Test
    @DisplayName("토큰 조회 테스트2")
    void getWaitTokenSuccessTest() {
        // given
        String tokenStr = "tokenStr";
        User user = User.builder().id(1L).name("user1").balance(100000L).build();
        Token token = new Token();
        token.create(tokenStr, 1, user);
        Long userId = 1L;


        // when
        when(tokenRepository.getTokenByUserId(anyLong())).thenReturn(Optional.of(token));

        // then
        assertThat(tokenService.getTokenByUserId(userId)).isEqualTo(token);
    }


}

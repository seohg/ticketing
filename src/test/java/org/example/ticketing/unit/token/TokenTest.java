package org.example.ticketing.unit.token;


import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.repository.TokenRepository;
import org.example.ticketing.domain.token.service.TokenService;
import org.example.ticketing.domain.user.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
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
        when(tokenRepository.getTokenByToken(tokenStr)).thenReturn(token);

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

    @Test
    @DisplayName("토큰 생성 테스트")
    void createTokenTest_isOngoing() {
        User user = mock(User.class);
        Token token = Token.create("token", 3, user);

        assertEquals(0, token.getWaitingNumber(3, 3));
        assertEquals(Status.ONGOING, token.getStatus());
    }
    @Test
    @DisplayName("토큰 생성 테스트")
    void createTokenTest_isWaiting() {
        User user = mock(User.class);
        Token token = Token.create("token", 15, user);

        assertEquals(2, token.getWaitingNumber(16, 15));
        assertEquals(Status.WAITING, token.getStatus());
    }

    @Test
    @DisplayName("토큰 만료처리테스트")
    void setTokenExpirationTest() {
        User user = mock(User.class);
        Token token = Token.create("token", 3, user);
        token.setExpirationTime(token.getExpirationTime().minusMinutes(20));
        token.setStatusIfTokenExpired();

        assertEquals(Status.EXPIRED, token.getStatus());
    }


}

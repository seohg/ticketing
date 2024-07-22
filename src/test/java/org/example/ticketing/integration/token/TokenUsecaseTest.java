package org.example.ticketing.integration.token;


import org.example.ticketing.application.token.TokenUseCase;
import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.interfaces.presentation.token.dto.TokenResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TokenUsecaseTest {
    @Autowired
    private TokenUseCase tokenUseCase;

    @Test
    @DisplayName("토큰 조회 테스트")
    void getTokenTest() {
        // given
        Long userId = 1L;
        TokenResponse tokenResponse = tokenUseCase.getToken(userId);

        // then
        assertThat(tokenResponse.getToken()).isEqualTo("token");
        assertThat(tokenResponse.getStatus()).isEqualTo(Status.ONGOING);
        assertThat(tokenResponse.getWaitNumber()).isEqualTo(0);
    }
    @Test
    @DisplayName("대기 토큰 발급 테스트")
    void issueWaitTokenTest() {
        // given
        Long userId = 2L;
        TokenResponse tokenResponse = tokenUseCase.issueToken(userId);

        // then
        assertThat(tokenResponse.getToken()).isNotNull();
        assertThat(tokenResponse.getStatus()).isEqualTo(Status.ONGOING);
        assertThat(tokenResponse.getWaitNumber()).isEqualTo(0);
    }
}

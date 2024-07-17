package org.example.ticketing;

import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.repository.UserRepository;
import org.example.ticketing.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 정상 조회 테스트")
    void getUserSuccessTest() {
        // given
        Long userId = 1L;

        // when
        when(userRepository.getUser(anyLong())).thenReturn(Optional.of(new User()));

        // then
        assertNotNull(userService.getUser(userId));
    }

    @Test
    @DisplayName("잔액 충전 테스트")
    void chargeBalanceSuccessTest() {
        // given
        User user = User.builder().id(1L).name("user1").balance(10000L).build();

        // when
        user.chargeBalance(5000L);

        // then
        assertEquals(15000, user.getBalance());
    }

    @Test
    @DisplayName("잔액 차감 성공 테스트")
    void paySuccessTest() {
        // given
        User user = User.builder().id(1L).name("user1").balance(10000L).build();

        // when
        user.pay(5000);

        // then
        assertEquals(5000, user.getBalance());
    }
    @Test
    @DisplayName("잔액 차감 실패 테스트")
    void payFailTest() {
        // given
        User user = User.builder().id(1L).name("user1").balance(10000L).build();

        // when, then
        assertThatThrownBy(() -> user.pay(15000))
                .isInstanceOf(BaseException.class);
    }



}

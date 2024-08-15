package org.example.ticketing.domain.token.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.user.model.User;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private Long id;
    private String token;
    private LocalDateTime accessTime;
    private LocalDateTime expirationTime;
    private Status status;
    private User user;

    private Token(String token, Status status, LocalDateTime accessTime, LocalDateTime expirationTime, User user) {
        this.token = token;
        this.status = status;
        this.accessTime = accessTime;
        this.expirationTime = expirationTime;
        this.user = user;
    }

    public static Token create(String token, long ongoingCount, User user) {
        if (ongoingCount >= 10) {
            return new Token(
                    token,
                    Status.WAITING,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusHours(3),
                    user
            );
        } else {
            return new Token(
                    token,
                    Status.ONGOING,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(10),
                    user
            );
        }
    }

    public void Expire() {
        this.status = Status.EXPIRED;
    }


    public boolean isExpired() {
        return expirationTime.isBefore(LocalDateTime.now());
    }

    public boolean isOngoing() {
        return status == Status.ONGOING;
    }

    public boolean isWaiting() {
        return status == Status.WAITING;
    }

    public void validateToken() {
        if (isExpired()) {
            throw new BaseException(ErrorMessage.TOKEN_EXPIRE);
        }
        if (!isOngoing()) {
            throw new BaseException(ErrorMessage.TOKEN_INVALID);
        }
    }

    public void setStatusIfTokenExpired() {
        if (isExpired()) {
            this.status = status.EXPIRED;
        }
    }

    public void plusValidTime() {
        this.expirationTime = LocalDateTime.now().plusMinutes(3);
    }

    public long getWaitingNumber(int unexpiredTokenSize, long ongoingNumber) {
        if (isWaiting()) {
            return unexpiredTokenSize - ongoingNumber + 1;
        }
        return 0;
    }
}
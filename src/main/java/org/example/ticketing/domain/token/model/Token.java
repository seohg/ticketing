package org.example.ticketing.domain.token.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.user.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Token(String token, Status status, LocalDateTime expirationTime, User user) {
        this.token = token;
        this.status = status;
        this.expirationTime = expirationTime;
        this.user = user;
    }

    public static Token create(String token, long ongoingCount, User user) {
        if (ongoingCount >= 10) {
            return new Token(
                    token,
                    Status.WAITING,
                    LocalDateTime.now().plusHours(3),
                    user
            );
        } else {
            return new Token(
                    token,
                    Status.ONGOING,
                    LocalDateTime.now().plusMinutes(10),
                    user
            );
        }
    }

    public void SetExpired() {
        setStatus(Status.EXPIRED);
    }

    public void SetOnGoing() {
        setStatus(Status.ONGOING);
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
            setStatus(Status.EXPIRED);
        }
    }
    public void plusValidTime() {
        setExpirationTime(LocalDateTime.now().plusMinutes(3));
    }

    public long getWaitingNumber(int unexpiredTokenSize, long ongoingNumber) {
        if (isWaiting()) {
            return unexpiredTokenSize - ongoingNumber + 1;
        }
        return 0;
    }

}
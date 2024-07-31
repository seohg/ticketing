package org.example.ticketing.infra.token.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;
import org.example.ticketing.domain.token.model.Status;
import org.example.ticketing.infra.user.entity.UserEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "access_time")
    private LocalDateTime accessTime;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
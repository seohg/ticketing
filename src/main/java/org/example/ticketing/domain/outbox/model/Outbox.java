package org.example.ticketing.domain.outbox.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
@NoArgsConstructor
@Getter
public class Outbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OutboxStatus status;

    private String message;

    private LocalDateTime createdTime;

    public Outbox(String message) {
        this.status = OutboxStatus.INIT;
        this.message = message;
        this.createdTime = LocalDateTime.now();
    }

    public void complete() {
        this.status = OutboxStatus.COMPLETED;
    }

    public void fail() {
        this.status = OutboxStatus.FAILED;
    }
}
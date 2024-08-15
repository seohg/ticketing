package org.example.ticketing.domain.outbox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "processed")
@Getter
public class Processed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageId;
    private LocalDateTime processedTime;

    public Processed(String messageId) {
        this.messageId = messageId;
        this.processedTime = LocalDateTime.now();
    }
}

package org.example.ticketing.infra.concert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="date", nullable = false)
    private LocalDateTime date;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    private ConcertEntity concert;

    private ShowEntity(LocalDateTime date, Integer capacity, ConcertEntity concert) {
        this.date = date;
        this.capacity = capacity;
        this.concert = concert;
    }

}
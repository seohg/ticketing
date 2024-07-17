package org.example.ticketing.domain.concert.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "show")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="date", nullable = false)
    private LocalDateTime date;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    private Show(LocalDateTime date, Integer capacity, Concert concert) {
        this.date = date;
        this.capacity = capacity;
        this.concert = concert;
    }

    public static Show create(LocalDateTime date, Integer capacity, Concert concert) {
        return new Show(date, capacity, concert);
    }
}
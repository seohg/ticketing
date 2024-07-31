package org.example.ticketing.domain.concert.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    private Long id;
    private LocalDateTime date;
    private Integer capacity;
    private Concert concert;

    private Show(LocalDateTime date, Integer capacity, Concert concert) {
        this.date = date;
        this.capacity = capacity;
        this.concert = concert;
    }

}
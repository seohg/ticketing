package org.example.ticketing.domain.concert.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Concert {
    private Long id;
    private String name;

    private Concert(String name) {
        this.name = name;
    }

}
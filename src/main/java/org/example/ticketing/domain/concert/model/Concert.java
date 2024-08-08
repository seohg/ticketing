package org.example.ticketing.domain.concert.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Concert implements Serializable {
    private Long id;
    private String name;

    private Concert(String name) {
        this.name = name;
    }

}
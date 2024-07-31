package org.example.ticketing.infra.concert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "concerts")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConcertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private ConcertEntity(String name) {
        this.name = name;
    }

}
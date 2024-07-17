package org.example.ticketing.domain.concert.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "concert")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private Concert(String name) {
        this.name = name;
    }

    public static Concert create(String name) {
        return new Concert(name);
    }
}
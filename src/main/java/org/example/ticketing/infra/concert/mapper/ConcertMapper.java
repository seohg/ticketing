package org.example.ticketing.infra.concert.mapper;

import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.infra.concert.entity.ConcertEntity;

public class ConcertMapper {
    public static Concert toDomain(ConcertEntity concertEntity) {
        return new Concert(concertEntity.getId(), concertEntity.getName());
    }

    public static ConcertEntity toEntity(Concert concert) {
        return new ConcertEntity(concert.getId(), concert.getName());
    }
}

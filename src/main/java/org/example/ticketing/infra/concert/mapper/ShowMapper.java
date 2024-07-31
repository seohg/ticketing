package org.example.ticketing.infra.concert.mapper;


import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.infra.concert.entity.ShowEntity;

public class ShowMapper {
    public static Show toDomain(ShowEntity showEntity) {
        return new Show(showEntity.getId(), showEntity.getDate(), showEntity.getCapacity(), ConcertMapper.toDomain(showEntity.getConcert()));
    }

    public static ShowEntity toEntity(Show show) {
        return new ShowEntity(show.getId(), show.getDate(), show.getCapacity(), ConcertMapper.toEntity(show.getConcert()));
    }
}

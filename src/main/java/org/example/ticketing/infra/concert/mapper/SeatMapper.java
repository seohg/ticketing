package org.example.ticketing.infra.concert.mapper;

import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.infra.concert.entity.SeatEntity;

public class SeatMapper {
    public static Seat toDomain(SeatEntity seatEntity) {
        return new Seat(seatEntity.getId(), seatEntity.getNumber(), seatEntity.getPrice(), seatEntity.getStatus(), seatEntity.getHoldTime(), ShowMapper.toDomain(seatEntity.getShowEntity()));
    }

    public static SeatEntity toEntity(Seat seat) {
        return new SeatEntity(seat.getId(), seat.getNumber(), seat.getPrice(), seat.getStatus(), seat.getHoldTime(), ShowMapper.toEntity(seat.getShow()));

    }
}

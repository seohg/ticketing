package org.example.ticketing.infra.reservation.mapper;

import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.infra.concert.mapper.SeatMapper;
import org.example.ticketing.infra.reservation.entity.ReservationEntity;
import org.example.ticketing.infra.user.mapper.UserMapper;

public class ReservationMapper {
    public static Reservation toDomain(ReservationEntity reservationEntity) {
        return new Reservation(reservationEntity.getId(), reservationEntity.getStatus(), reservationEntity.getPrice(), SeatMapper.toDomain(reservationEntity.getSeatEntity()), UserMapper.toDomain(reservationEntity.getUserEntity()));
    }

    public static ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(reservation.getId(), reservation.getStatus(), reservation.getPrice(), SeatMapper.toEntity(reservation.getSeat()), UserMapper.toEntity(reservation.getUser()));

    }
}

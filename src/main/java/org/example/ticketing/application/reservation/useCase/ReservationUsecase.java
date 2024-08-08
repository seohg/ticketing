package org.example.ticketing.application.reservation.useCase;


import lombok.RequiredArgsConstructor;
import org.example.ticketing.common.aop.DistributedLock;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.service.SeatService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.example.ticketing.domain.token.model.Token;
import org.example.ticketing.domain.token.service.TokenService;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.example.ticketing.interfaces.presentation.reservation.dto.ReservationResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class ReservationUsecase {
    private final TokenService tokenService;
    private final UserService userService;
    private final SeatService seatService;
    private final ReservationService reservationService;

    @DistributedLock(key = "#reserve")
    public ReservationResponse reserve(String tokenStr, Long seatId) {
        Token token = tokenService.getTokenByToken(tokenStr);
        User user = userService.getUser(token.getUser().getId());
        Seat seat = seatService.getSeat(seatId);

        // 좌석 확인 및 홀드
        seat.checkIsValid();
        seat.holdSeat();

        // 예약
        Reservation reservation = new Reservation(seat, user);
        reservationService.reserve(reservation);
        seatService.setSeat(seat);

        // 토큰 만료
        token.SetExpired();
        return new ReservationResponse(reservation.getId(), reservation.getStatus(), reservation.getPrice() );
    }
}



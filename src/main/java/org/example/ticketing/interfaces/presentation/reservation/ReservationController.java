package org.example.ticketing.interfaces.presentation.reservation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.application.concert.useCase.ConcertUsecase;
import org.example.ticketing.application.reservation.useCase.ReservationUsecase;
import org.example.ticketing.interfaces.presentation.concert.dto.SeatResponse;
import org.example.ticketing.interfaces.presentation.concert.dto.ShowDateResponse;
import org.example.ticketing.interfaces.presentation.reservation.dto.ReservationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Reservation", description = "예약 요청 API")
public class ReservationController {
    private final ReservationUsecase reservationUsecase;
    @Operation(summary = "좌석 예약 요청", description = "좌석 예약 요청", responses = {
            @ApiResponse(responseCode = "200", description = "예약 가능한 좌석 목록 반환")
    }
    )
    @PostMapping("/seats/{seatid}")
    public ResponseEntity<ReservationResponse> reserveSeat(
            @RequestHeader String token,
            @PathVariable Long seatId
    ) {
        return ResponseEntity.ok(reservationUsecase.reserve(token, seatId));
    }
}
package org.example.ticketing.interfaces.presentation.concert;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ticketing.application.concert.ConcertUsecase;
import org.example.ticketing.application.concert.ReservationUsecase;
import org.example.ticketing.interfaces.presentation.concert.dto.SeatResponse;
import org.example.ticketing.interfaces.presentation.concert.dto.ShowDateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Concert Reservation", description = "예약 관련 조회 및 요청 API")
public class ConcertController {
    private final ConcertUsecase concertUsecase;
    private final ReservationUsecase reservationUsecase;
    @Operation(summary = "예약가능 날짜 조회", description = "예약가능 날짜 조회", responses = {
            @ApiResponse(responseCode = "200", description = "예약 가능한 날짜 목록 반환")
            }
    )
    @PostMapping("/concerts/{concertid}/shows")
    public List<ShowDateResponse> getDate(
            @RequestHeader String token,
            @PathVariable Long concertId
    ) {
        return concertUsecase.getShowDate(concertId);
    }

    @Operation(summary = "예약가능 좌석 조회", description = "예약가능 좌석 조회", responses = {
            @ApiResponse(responseCode = "200", description = "예약 가능한 좌석 목록 반환")
        }
    )
    @GetMapping("/shows/{showid}/seats")
    public List<SeatResponse> getSeat(
            @RequestHeader String token,
            @PathVariable Long showId
    ) {
        return concertUsecase.getSeatList(showId);
    }

    @Operation(summary = "좌석 예약 요청", description = "좌석 예약 요청", responses = {
            @ApiResponse(responseCode = "200", description = "예약 가능한 좌석 목록 반환")
    }
    )
    @PostMapping("/seats/{seatid}")
    public ResponseEntity<Void> reserveSeat(
            @RequestHeader String token,
            @PathVariable Long seatId
    ) {
        reservationUsecase.reserve(token, seatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
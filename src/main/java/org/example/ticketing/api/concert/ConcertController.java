package org.example.ticketing.api.concert;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.api.concert.dto.SeatResponse;
import org.example.ticketing.api.concert.dto.ShowDateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ConcertController {

    @PostMapping("/concerts/{concertid}/shows")
    public ShowDateResponse getDate(
            @RequestHeader String token,
            @PathVariable Long concertid
    ) {
        return new ShowDateResponse(1L, LocalDateTime.now());
    }

    @GetMapping("/shows/{showid}/seats")
    public SeatResponse getSeat(
            @RequestHeader String token,
            @PathVariable Long showid
    ) {
        return new SeatResponse(1L, 10L);
    }

    @PostMapping("/shows/{showid}/seats/{seatid}")
    public ResponseEntity<Void> reserveSeat(
            @RequestHeader String token,
            @PathVariable Long showid,
            @PathVariable Long seatid
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
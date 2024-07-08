package org.example.ticketing.api.concert.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ShowDateResponse {

    private long showId;
    private LocalDateTime date;

    public ShowDateResponse (long showId, LocalDateTime date) {
        this.showId = showId;
        this.date = date;
    }
}
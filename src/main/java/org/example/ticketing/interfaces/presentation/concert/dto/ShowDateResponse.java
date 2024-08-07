package org.example.ticketing.interfaces.presentation.concert.dto;

import lombok.Getter;
import org.example.ticketing.domain.concert.model.Show;

import java.time.LocalDateTime;

@Getter
public class ShowDateResponse {

    private long showId;
    private LocalDateTime date;

    public ShowDateResponse (long showId, LocalDateTime date) {
        this.showId = showId;
        this.date = date;
    }
    public static ShowDateResponse from(Show show) {
        return new ShowDateResponse(show.getId(), show.getDate());
    }
}
package org.example.ticketing.common.config;

import org.example.ticketing.domain.concert.model.Concert;
import org.example.ticketing.domain.concert.model.Show;
import org.example.ticketing.domain.concert.model.Seat;
import org.example.ticketing.domain.concert.model.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class Data {

    private final JdbcTemplate jdbcTemplate;

   /// @Bean
    ApplicationRunner init() {
        return args -> insertMockData();
    }

    public void insertMockData() {
        long concertSize = 10;
        long showSize = 1000;
        long seatSize = 100000;
        int batchSize = 10000;

        List<Concert> concerts = new ArrayList<>();
        List<Show> shows = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();

        Random random = new Random();
        int dateRange = 365;
        int randomDays = random.nextInt(2 * dateRange + 1) - dateRange;

            for (int j = 1; j <= showSize; j++) {



              /*  for (int k = 1; k < seatSize; k++) {

                    Seat seat = Seat.builder()
                            .show_id(j)
                            .holdTime(LocalDateTime.now().plusDays(randomDays))
                            .price(100000 + random.nextInt() * 10000)
                            .number((long) k)
                            .status(random.nextBoolean() ? SeatStatus.EMPTY : SeatStatus.RESERVED)
                            .build();
                    seats.add(seat);



                }*/
                //batchInsertSeats(seats);

                seats.clear();

            }






    }

}

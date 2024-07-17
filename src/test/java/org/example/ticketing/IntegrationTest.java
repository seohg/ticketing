package org.example.ticketing;

import org.example.ticketing.api.concert.ReservationUsecase;
import org.example.ticketing.infra.reservation.ReservationJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IntegrationTest {
    @Autowired
    private ReservationUsecase reservationUsecase;


    @Autowired
    private ReservationJpaRepository reservationJpaRepository;
    @Test
    @DisplayName("동시성 테스트")
    void reserveTest() throws InterruptedException {
        // given
        int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(() -> {
                try {
                    reservationUsecase.reserve("tokenString", 1L);
                    count.getAndIncrement();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        assertThat(reservationJpaRepository.findAll().size()).isEqualTo(1);
    }
}

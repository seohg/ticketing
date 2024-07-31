package org.example.ticketing.integration;

import org.example.ticketing.application.reservation.useCase.ReservationUsecase;
import org.example.ticketing.infra.reservation.ReservationJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class IntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(IntegrationTest.class);

    @Autowired
    private ReservationUsecase reservationUsecase;


    @Autowired
    private ReservationJpaRepository reservationJpaRepository;
    @Test
    @DisplayName("동시성 테스트")
    @Transactional
    void reserveTest() throws InterruptedException {
        Long startTime = System.currentTimeMillis();

        // given
        int numberOfThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(() -> {
                try {
                    reservationUsecase.reserve("token", 1L);
                    count.getAndIncrement();
                } catch (Exception e) {
                    log.info("Exception because: {}", Thread.currentThread().getName(), e.getMessage());
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        assertThat(reservationJpaRepository.findAll().size()).isEqualTo(1);
        Long endTime = System.currentTimeMillis();
        log.info("소요 시간: {}", (endTime - startTime) + "ms");

    }
}

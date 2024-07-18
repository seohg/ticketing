package org.example.ticketing.interfaces.presentation.payment;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.service.PaymentService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PaymentUseCase {
    private final ReservationService reservationService;
    private final UserService userService;
    private final PaymentService paymentService;

    public void pay(Long reservationId) {
        Reservation reservation = reservationService.getReservation(reservationId);
        User user = userService.getUser(reservation.getUser().getId());

        // 결제
        user.pay(reservation.getPrice());
        reservation.complete();

        Payment payment = Payment.create(reservation.getPrice(), reservation);
        paymentService.setPayment(payment);
    }
}

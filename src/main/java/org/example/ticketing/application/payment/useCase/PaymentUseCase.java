package org.example.ticketing.application.payment.useCase;

import lombok.RequiredArgsConstructor;
import org.example.ticketing.domain.payment.model.Payment;
import org.example.ticketing.domain.payment.service.PaymentService;
import org.example.ticketing.domain.reservation.model.Reservation;
import org.example.ticketing.domain.reservation.service.ReservationService;
import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.domain.user.service.UserService;
import org.example.ticketing.interfaces.presentation.payment.dto.PaymentResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PaymentUseCase {
    private final ReservationService reservationService;
    private final UserService userService;
    private final PaymentService paymentService;

    public PaymentResponse pay(Long reservationId) {
        Reservation reservation = reservationService.getReservation(reservationId);
        User user = userService.getUser(reservation.getUser().getId());

        // 결제
        reservation.complete();
        user.pay(reservation.getPrice());

        Payment payment = new Payment(reservation.getPrice(), reservation);
        paymentService.setPayment(payment);

        return new PaymentResponse(payment.getId(), payment.getAmount(), payment.getStatus() );
    }
}

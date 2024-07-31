package org.example.ticketing.interfaces.presentation.payment.dto;

import org.example.ticketing.domain.payment.model.PaymentStatus;
import org.example.ticketing.domain.reservation.model.ReservationStatus;

public class PaymentResponse {
    private Long paymentId;
    private Integer amount;
    private PaymentStatus status;

    public PaymentResponse(Long paymentId, Integer amount, PaymentStatus status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
    }
}

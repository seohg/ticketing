package org.example.ticketing.interfaces.presentation.payment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.application.payment.useCase.PaymentUseCase;
import org.example.ticketing.interfaces.presentation.payment.dto.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment", description = "결제 관련 API")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentUseCase paymentUseCase;

    @Operation(summary = "결제", description = "결제", responses = {
            @ApiResponse(responseCode = "200", description = "결제 성공 여부 리턴")
        }
    )
    @PostMapping("/reservations/{reservationId}")
    public ResponseEntity<PaymentResponse> pay(
            @PathVariable Long reservationId
    ) {

        return ResponseEntity.ok(paymentUseCase.pay(reservationId));
    }
}

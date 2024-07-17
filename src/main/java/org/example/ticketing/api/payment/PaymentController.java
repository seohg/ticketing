package org.example.ticketing.api.payment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.ticketing.api.payment.dto.PayRequest;
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
    public ResponseEntity<Void> pay(
            @PathVariable Long reservationId
    ) {
        paymentUseCase.pay(reservationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

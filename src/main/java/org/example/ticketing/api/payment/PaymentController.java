package org.example.ticketing.api.payment;

import org.example.ticketing.api.payment.dto.PayRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @PostMapping
    public ResponseEntity<Void> pay(
            @RequestBody PayRequest request,
            @PathVariable Long userid
    ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

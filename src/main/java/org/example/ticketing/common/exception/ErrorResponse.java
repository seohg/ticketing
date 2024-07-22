package org.example.ticketing.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;

    @Builder
    private ErrorResponse(
            int status, String message
    ) {
        this.status = status;
        this.message = message;
    }

    public static ResponseEntity<ErrorResponse> toResponseEntity(
            String errorMessage, HttpStatus status
    ) {
        return ResponseEntity
                .status(status)
                .body(ErrorResponse.builder()
                        .message(errorMessage)
                        .build()
                );
    }
}
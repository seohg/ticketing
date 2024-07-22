package org.example.ticketing.common.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(BaseException e, HttpServletRequest request) {

        log.error("[ExceptionHandler] {} : {}",e.getErrorCode(), e.getErrorMessage());
        return ErrorResponse.toResponseEntity(e.getMessage(), e.getHttpStatus());
    }
}

package org.example.ticketing.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {
    TOKEN_EXPIRE(4001, "토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    TOKEN_INVALID(4002, "진행중인 토큰이 아닙니다.", HttpStatus.UNAUTHORIZED),
    TOKEN_NOT_FOUND(4003, "토큰이 잘못되었습니다.", HttpStatus.UNAUTHORIZED),
    EXIST_TOKEN(4004, "이미 존재하는 토큰입니다.", HttpStatus.UNAUTHORIZED),

    OCCUPIED_SEAT(3001, "이미 예약된 좌석입니다.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(3002, "존재하지 않는 유저입니다.", HttpStatus.BAD_REQUEST),
    SEAT_NOT_FOUND(3003, "존재하지 않는 좌석입니다.", HttpStatus.BAD_REQUEST),
    INVALID_CHARGE_AMOUNT(3004, "0 이상의 금액만 충전 가능합니다.", HttpStatus.BAD_REQUEST),
    RESERVATION_NOT_FOUND(3005, "존재하지 않는 예약건입니다.", HttpStatus.BAD_REQUEST),
    INVALID_BALANCE(3006, "잔액이 부족합니다.", HttpStatus.BAD_REQUEST),
    PAYMENT_NOT_FOUND(3003, "존재하지 않는 결제건입니다.", HttpStatus.BAD_REQUEST);

    private final Integer code;
    private final String errMsg;
    private final HttpStatus httpStatus;

    ErrorMessage(int code, String errMsg, HttpStatus httpStatus) {
        this.code = code;
        this.errMsg = errMsg;
        this.httpStatus = httpStatus;
    }

    public int getErrorCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errMsg;
    }
}
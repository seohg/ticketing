package org.example.ticketing.domain.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Long balance;

    public User chargeBalance(Long amount) {
        if (amount < 0) {
            throw new BaseException(ErrorMessage.INVALID_CHARGE_AMOUNT);
        }
        this.balance += amount;
        return this;
    }

    public void pay(Integer amount) {
        if (amount < 0) {
            throw new BaseException(ErrorMessage.INVALID_CHARGE_AMOUNT);
        }
        if (this.balance < amount) {
            throw new BaseException(ErrorMessage.INVALID_BALANCE);
        }
        this.balance -= amount;
    }
}
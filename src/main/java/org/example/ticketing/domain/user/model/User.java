package org.example.ticketing.domain.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "balance", nullable = false)
    private Long balance;

    public User(String name, Long balance) {
        this.name = name;
        this.balance = balance;
    }


    public void chargeBalance(Long amount) {
        if (amount < 0) {
            throw new BaseException(ErrorMessage.INVALID_CHARGE_AMOUNT);
        }
        this.balance += amount;
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
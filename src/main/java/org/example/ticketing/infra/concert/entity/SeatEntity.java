package org.example.ticketing.infra.concert.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.ticketing.domain.concert.model.SeatStatus;
import org.example.ticketing.common.exception.BaseException;
import org.example.ticketing.common.exception.ErrorMessage;

import java.time.LocalDateTime;

@Entity
@Table(name = "seats"
     ,indexes = {
        @Index(name = "seat_idx", columnList = "show_id, status")
    }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Column(name = "hold_time")
    private LocalDateTime holdTime;

    @ManyToOne
    @JoinColumn(name = "show_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ShowEntity showEntity;

    private SeatEntity(Long number, Integer price, SeatStatus status, LocalDateTime holdTime, ShowEntity showEntity) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.holdTime = holdTime;
        this.showEntity = showEntity;
    }

    public static SeatEntity create(Long number, Integer price, ShowEntity show) {
        return new SeatEntity(number, price, SeatStatus.EMPTY, null, show);
    }

    public void holdSeat() {
        this.status = SeatStatus.HOLD;
        this.holdTime = LocalDateTime.now().plusMinutes(5);
    }

    public boolean isEmpty() {
        return this.status == SeatStatus.EMPTY;
    }

    public void checkIsValid() {
        if (!isEmpty()) {
            throw new BaseException(ErrorMessage.OCCUPIED_SEAT);
        }
    }
    public void SetEmptyIfTimeExpired() {
        if (holdTime.isBefore(LocalDateTime.now())) {
            setStatus(SeatStatus.EMPTY);
        }
    }
}
package org.example.ticketing.domain.payment.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.example.ticketing.application.payment.dto.PaymentStatus;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = 798745461L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.example.ticketing.domain.reservation.model.QReservation reservation;

    public final EnumPath<PaymentStatus> status = createEnum("status", PaymentStatus.class);

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new org.example.ticketing.domain.reservation.model.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}


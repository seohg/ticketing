package org.example.ticketing.infra.reservation.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationEntity is a Querydsl query type for ReservationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationEntity extends EntityPathBase<ReservationEntity> {

    private static final long serialVersionUID = -1344028918L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationEntity reservationEntity = new QReservationEntity("reservationEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final org.example.ticketing.infra.concert.entity.QSeatEntity seatEntity;

    public final EnumPath<org.example.ticketing.domain.reservation.model.ReservationStatus> status = createEnum("status", org.example.ticketing.domain.reservation.model.ReservationStatus.class);

    public final org.example.ticketing.infra.user.entity.QUserEntity userEntity;

    public QReservationEntity(String variable) {
        this(ReservationEntity.class, forVariable(variable), INITS);
    }

    public QReservationEntity(Path<? extends ReservationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationEntity(PathMetadata metadata, PathInits inits) {
        this(ReservationEntity.class, metadata, inits);
    }

    public QReservationEntity(Class<? extends ReservationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.seatEntity = inits.isInitialized("seatEntity") ? new org.example.ticketing.infra.concert.entity.QSeatEntity(forProperty("seatEntity"), inits.get("seatEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new org.example.ticketing.infra.user.entity.QUserEntity(forProperty("userEntity")) : null;
    }

}


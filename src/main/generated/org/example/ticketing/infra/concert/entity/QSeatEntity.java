package org.example.ticketing.infra.concert.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeatEntity is a Querydsl query type for SeatEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeatEntity extends EntityPathBase<SeatEntity> {

    private static final long serialVersionUID = -1005338425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeatEntity seatEntity = new QSeatEntity("seatEntity");

    public final DateTimePath<java.time.LocalDateTime> holdTime = createDateTime("holdTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QShowEntity showEntity;

    public final EnumPath<org.example.ticketing.domain.concert.model.SeatStatus> status = createEnum("status", org.example.ticketing.domain.concert.model.SeatStatus.class);

    public QSeatEntity(String variable) {
        this(SeatEntity.class, forVariable(variable), INITS);
    }

    public QSeatEntity(Path<? extends SeatEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeatEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeatEntity(PathMetadata metadata, PathInits inits) {
        this(SeatEntity.class, metadata, inits);
    }

    public QSeatEntity(Class<? extends SeatEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.showEntity = inits.isInitialized("showEntity") ? new QShowEntity(forProperty("showEntity"), inits.get("showEntity")) : null;
    }

}


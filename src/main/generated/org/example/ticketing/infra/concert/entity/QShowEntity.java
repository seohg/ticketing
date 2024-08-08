package org.example.ticketing.infra.concert.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShowEntity is a Querydsl query type for ShowEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShowEntity extends EntityPathBase<ShowEntity> {

    private static final long serialVersionUID = -840682561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShowEntity showEntity = new QShowEntity("showEntity");

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final QConcertEntity concert;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QShowEntity(String variable) {
        this(ShowEntity.class, forVariable(variable), INITS);
    }

    public QShowEntity(Path<? extends ShowEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShowEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShowEntity(PathMetadata metadata, PathInits inits) {
        this(ShowEntity.class, metadata, inits);
    }

    public QShowEntity(Class<? extends ShowEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.concert = inits.isInitialized("concert") ? new QConcertEntity(forProperty("concert")) : null;
    }

}


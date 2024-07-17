package org.example.ticketing.domain.concert.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShow is a Querydsl query type for Show
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShow extends EntityPathBase<Show> {

    private static final long serialVersionUID = 671959886L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShow show = new QShow("show");

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final QConcert concert;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QShow(String variable) {
        this(Show.class, forVariable(variable), INITS);
    }

    public QShow(Path<? extends Show> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShow(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShow(PathMetadata metadata, PathInits inits) {
        this(Show.class, metadata, inits);
    }

    public QShow(Class<? extends Show> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.concert = inits.isInitialized("concert") ? new QConcert(forProperty("concert")) : null;
    }

}


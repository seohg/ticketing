package org.example.ticketing.infra.concert.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcertEntity is a Querydsl query type for ConcertEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QConcertEntity extends EntityPathBase<ConcertEntity> {

    private static final long serialVersionUID = 1551513418L;

    public static final QConcertEntity concertEntity = new QConcertEntity("concertEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QConcertEntity(String variable) {
        super(ConcertEntity.class, forVariable(variable));
    }

    public QConcertEntity(Path<? extends ConcertEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcertEntity(PathMetadata metadata) {
        super(ConcertEntity.class, metadata);
    }

}


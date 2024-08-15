package org.example.ticketing.domain.outbox.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProcessed is a Querydsl query type for Processed
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProcessed extends EntityPathBase<Processed> {

    private static final long serialVersionUID = -802616132L;

    public static final QProcessed processed = new QProcessed("processed");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath messageId = createString("messageId");

    public final DateTimePath<java.time.LocalDateTime> processedTime = createDateTime("processedTime", java.time.LocalDateTime.class);

    public QProcessed(String variable) {
        super(Processed.class, forVariable(variable));
    }

    public QProcessed(Path<? extends Processed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcessed(PathMetadata metadata) {
        super(Processed.class, metadata);
    }

}


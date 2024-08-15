package org.example.ticketing.domain.outbox.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOutbox is a Querydsl query type for Outbox
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOutbox extends EntityPathBase<Outbox> {

    private static final long serialVersionUID = 378947855L;

    public static final QOutbox outbox = new QOutbox("outbox");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final EnumPath<OutboxStatus> status = createEnum("status", OutboxStatus.class);

    public QOutbox(String variable) {
        super(Outbox.class, forVariable(variable));
    }

    public QOutbox(Path<? extends Outbox> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOutbox(PathMetadata metadata) {
        super(Outbox.class, metadata);
    }

}


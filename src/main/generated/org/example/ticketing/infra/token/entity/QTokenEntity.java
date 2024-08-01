package org.example.ticketing.infra.token.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTokenEntity is a Querydsl query type for TokenEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTokenEntity extends EntityPathBase<TokenEntity> {

    private static final long serialVersionUID = -500890774L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTokenEntity tokenEntity = new QTokenEntity("tokenEntity");

    public final DateTimePath<java.time.LocalDateTime> accessTime = createDateTime("accessTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> expirationTime = createDateTime("expirationTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<org.example.ticketing.domain.token.model.Status> status = createEnum("status", org.example.ticketing.domain.token.model.Status.class);

    public final StringPath token = createString("token");

    public final org.example.ticketing.infra.user.entity.QUserEntity userEntity;

    public QTokenEntity(String variable) {
        this(TokenEntity.class, forVariable(variable), INITS);
    }

    public QTokenEntity(Path<? extends TokenEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTokenEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTokenEntity(PathMetadata metadata, PathInits inits) {
        this(TokenEntity.class, metadata, inits);
    }

    public QTokenEntity(Class<? extends TokenEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEntity = inits.isInitialized("userEntity") ? new org.example.ticketing.infra.user.entity.QUserEntity(forProperty("userEntity")) : null;
    }

}


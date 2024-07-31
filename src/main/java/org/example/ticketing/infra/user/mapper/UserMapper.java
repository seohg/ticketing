package org.example.ticketing.infra.user.mapper;

import org.example.ticketing.domain.user.model.User;
import org.example.ticketing.infra.user.entity.UserEntity;

public class UserMapper {
    public static User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getBalance());
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getBalance());
    }
}

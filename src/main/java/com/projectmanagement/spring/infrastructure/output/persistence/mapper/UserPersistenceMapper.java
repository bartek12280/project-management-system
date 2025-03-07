package com.projectmanagement.spring.infrastructure.output.persistence.mapper;

import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);
}

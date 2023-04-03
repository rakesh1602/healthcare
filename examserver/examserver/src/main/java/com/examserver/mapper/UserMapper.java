package com.examserver.mapper;

import com.examserver.entity.UserEntity;
import com.examserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "roleList", target = "roleEntitySet")
    UserEntity modelToEntity(User user);

    User entityToModel(UserEntity userEntity);
}

package com.examserver.mapper;

import com.examserver.entity.RoleEntity;
import com.examserver.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleEntity modelToEntity(Role role);
    Role entityToMode(RoleEntity roleEntity);
}

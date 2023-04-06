package com.spring.docon.mapper;

import com.spring.docon.entity.UserRegisterEntity;
import com.spring.docon.model.UserRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {

    @Mapping(source = "account", target = "accountEntity")
    UserRegisterEntity modelToEntity(UserRegister userRegister);
}

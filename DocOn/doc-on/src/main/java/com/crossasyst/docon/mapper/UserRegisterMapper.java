package com.crossasyst.docon.mapper;

import com.crossasyst.docon.entity.UserRegisterEntity;
import com.crossasyst.docon.model.UserRegister;
import com.crossasyst.docon.response.UserRegisterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {

    @Mapping(source = "account", target = "accountEntity")
    UserRegisterEntity modelToEntity(UserRegister userRegister);
    UserRegisterResponse response (UserRegisterEntity userRegisterEntity);
}

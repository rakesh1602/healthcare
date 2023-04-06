package com.spring.docon.mapper;

import com.spring.docon.entity.PatientEntity;
import com.spring.docon.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "user", target = "userRegisterEntity")
    @Mapping(source = "user.account", target = "userRegisterEntity.accountEntity")
    PatientEntity modelToEntity(Patient patient);
}

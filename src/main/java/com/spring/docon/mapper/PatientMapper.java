package com.spring.docon.mapper;

import com.spring.docon.entity.PatientEntity;
import com.spring.docon.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "user", target = "userRegisterEntity")
    @Mapping(source = "user.account", target = "userRegisterEntity.accountEntity")
    PatientEntity modelToEntity(Patient patient);

    Patient toModel(PatientEntity patientEntity);

    List<Patient> toModels(List<PatientEntity> patientEntities);
}

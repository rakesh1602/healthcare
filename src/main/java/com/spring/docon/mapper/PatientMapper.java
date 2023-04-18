package com.spring.docon.mapper;

import com.spring.docon.entity.PatientEntity;
import com.spring.docon.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

<<<<<<< HEAD
import java.util.Optional;
=======
import java.util.List;
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11

@Mapper(componentModel = "spring")
public interface PatientMapper {

<<<<<<< HEAD
    @Mapping(source = "person", target = "userRegisterEntity")
    @Mapping(source = "person.account", target = "userRegisterEntity.accountEntity")
    PatientEntity modelToEntity(Patient patient);

    Patient entityToModel(Optional<PatientEntity> patientEntity);
=======
    @Mapping(source = "user", target = "user")
    PatientEntity modelToEntity(Patient patient);

    Patient entityToModel(PatientEntity patientEntity);

    List<Patient> toModels(List<PatientEntity> patientEntities);
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
}

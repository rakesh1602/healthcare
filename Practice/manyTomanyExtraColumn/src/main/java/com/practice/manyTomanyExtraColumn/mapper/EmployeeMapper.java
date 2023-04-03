package com.practice.manyTomanyExtraColumn.mapper;


import com.practice.manyTomanyExtraColumn.entity.EmployeeEntity;
import com.practice.manyTomanyExtraColumn.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToModel(EmployeeEntity employeeEntity);

    EmployeeEntity modelToEntity(Employee employee);
}

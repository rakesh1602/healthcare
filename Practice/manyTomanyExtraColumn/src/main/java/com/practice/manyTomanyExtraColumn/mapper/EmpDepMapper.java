package com.practice.manyTomanyExtraColumn.mapper;

import com.practice.manyTomanyExtraColumn.entity.EmployeeEntity;
import com.practice.manyTomanyExtraColumn.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpDepMapper {
    EmployeeEntity modelToEntity (Employee employee);

}

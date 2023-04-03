package com.practice.manyTomanyExtraColumn.service;

import com.practice.manyTomanyExtraColumn.entity.EmployeeEntity;
import com.practice.manyTomanyExtraColumn.mapper.EmployeeMapper;
import com.practice.manyTomanyExtraColumn.model.Employee;
import com.practice.manyTomanyExtraColumn.repository.EmployeeRepository;
import com.practice.manyTomanyExtraColumn.response.EmployeeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        EmployeeEntity employeeEntity=employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        employeeResponse.setId(employeeEntity.getId());
        log.info("Employees details has been saved !!");
        return employeeResponse;
    }
}

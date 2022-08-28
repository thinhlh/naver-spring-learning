package com.thinhlh.btvn14.app.employee.domain.service;

import com.thinhlh.btvn14.app.employee.controller.dto.CreateEmployeeDTO;
import com.thinhlh.btvn14.app.employee.controller.dto.EmployeeMybasticResponse;
import com.thinhlh.btvn14.app.employee.controller.dto.EmployeeResponse;
import com.thinhlh.btvn14.app.employee.controller.dto.UpdateEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeMybasticResponse getEmployeeMybastic(Long id);

    EmployeeResponse createEmployee(CreateEmployeeDTO employee);

    EmployeeResponse updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO);

    Object deleteEmployee(Long id);
}

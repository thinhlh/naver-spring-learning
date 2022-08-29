package com.thinhlh.btvn13.app.employee.domain.service;

import com.thinhlh.btvn13.app.employee.controller.dto.CreateEmployeeDTO;
import com.thinhlh.btvn13.app.employee.controller.dto.EmployeeResponse;
import com.thinhlh.btvn13.app.employee.controller.dto.UpdateEmployeeDTO;
import com.thinhlh.btvn13.app.employee.domain.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse createEmployee(CreateEmployeeDTO employee);

    EmployeeResponse updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO);

    Object deleteEmployee(Long id);
}

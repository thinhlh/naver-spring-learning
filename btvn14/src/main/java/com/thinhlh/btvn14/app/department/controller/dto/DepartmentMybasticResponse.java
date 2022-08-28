package com.thinhlh.btvn14.app.department.controller.dto;

import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentMybasticResponse {
    private Long id;
    private Long totalEmployees;
    private String departmentName;
    private String description;
    private List<Employee> employees;
}

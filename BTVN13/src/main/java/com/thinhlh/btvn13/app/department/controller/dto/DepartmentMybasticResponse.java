package com.thinhlh.btvn13.app.department.controller.dto;

import com.thinhlh.btvn13.app.employee.domain.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentMybasticResponse {
    private Long id;
    private Long duntknow;
    private String departmentName;
    private List<Employee> employees;
}

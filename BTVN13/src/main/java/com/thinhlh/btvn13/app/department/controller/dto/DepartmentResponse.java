package com.thinhlh.btvn13.app.department.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.app.employee.controller.dto.EmployeeResponse;
import com.thinhlh.btvn13.app.employee.domain.entity.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DepartmentResponse  extends Department {

    @JsonProperty("employees")
    @Override
    public List<Employee> getEmployees() {
        return super.getEmployees();
    }
}

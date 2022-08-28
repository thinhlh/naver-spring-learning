package com.thinhlh.btvn14.app.employee.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.employee.domain.entity.Employee;

public class EmployeeResponse extends Employee {

    @JsonProperty("department")
    public Department getDepartment() {
        return super.getDepartment();
    }
}

package com.thinhlh.btvn13.app.employee.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.app.employee.domain.entity.Employee;
import com.thinhlh.btvn13.helpers.DateTimeHelper;

import java.util.Date;

public class EmployeeResponse extends Employee {

    @JsonProperty("department")
    public Department getDepartment() {
        return super.getDepartment();
    }
}

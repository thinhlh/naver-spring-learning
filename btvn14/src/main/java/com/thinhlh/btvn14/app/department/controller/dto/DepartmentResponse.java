package com.thinhlh.btvn14.app.department.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentResponse extends Department {

    @JsonProperty("employees")
    public List<Employee> getEmployees() {
        return super.getEmployees();
    }
}

package com.thinhlh.btvn14.app.employee.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.employee.domain.entity.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeMybasticResponse {
    private Long id;
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;
    private Gender gender;
    private Department department;
}

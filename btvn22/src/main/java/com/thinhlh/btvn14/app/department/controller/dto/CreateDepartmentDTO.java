package com.thinhlh.btvn14.app.department.controller.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateDepartmentDTO {

    @NotBlank(message = "Department name cannot be blank!")
    private String departmentName;

    @NotBlank(message = "Description cannot be blank!")
    private String description;
}

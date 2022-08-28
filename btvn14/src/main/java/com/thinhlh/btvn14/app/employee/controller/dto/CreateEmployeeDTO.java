package com.thinhlh.btvn14.app.employee.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinhlh.btvn14.app.employee.domain.entity.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Getter
@Setter
public class CreateEmployeeDTO {

    @NotBlank(message = "Employee name cannot be blank!")
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;

    @NotNull(message = "Gender cannot be null!")
    private Gender gender;

    @Positive(message = "DepartmentID must be positive")
    private Long departmentId;
}

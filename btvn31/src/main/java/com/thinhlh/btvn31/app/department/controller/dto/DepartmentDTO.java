package com.thinhlh.btvn31.app.department.controller.dto;

import com.thinhlh.btvn31.app.employee.controller.dto.EmployeeDTO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DepartmentDTO {
    @NotNull(message = "Department ID must not be empty")
    @Positive(message = "Department ID must be positive!")
    private Long departmentId;

    @NotBlank(message = "Department name must not be blank")
    @Size(min = 10,max = 50, message = "Department name must be valid (10<=characters<=50)")
    private String deptName;

    @NotBlank(message = "Department description must not be blank")
    private String description;

    @Valid
    private List<EmployeeDTO> employees;
}

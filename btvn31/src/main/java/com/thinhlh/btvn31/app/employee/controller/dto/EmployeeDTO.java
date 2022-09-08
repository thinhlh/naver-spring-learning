package com.thinhlh.btvn31.app.employee.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class EmployeeDTO {
    @NotNull(message = "Employee ID must not be empty")
    @Positive(message = "Employee ID must be positive!")
    private Long employeeId;

    @NotBlank(message = "Employee name must not be blank")
    @Size(min = 10, max = 50, message = "Employee name must be valid (10<=characters<=50)")
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    @Pattern(regexp = "(MALE|FEMALE)", message = "Gender must be either MALE or FEMALE")
    private String gender;

    @Email(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$", message = "Email not valid!")
    @NotBlank(message = "Email must not be empty!")
    private String email;

}

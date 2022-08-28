package com.thinhlh.btvn13.app.employee.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinhlh.btvn13.app.employee.domain.entity.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmployeeDTO {
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;
    private Gender gender;
    private Long departmentId;
}

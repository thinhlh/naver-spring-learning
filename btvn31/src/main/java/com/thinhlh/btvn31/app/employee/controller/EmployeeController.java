package com.thinhlh.btvn31.app.employee.controller;

import com.thinhlh.btvn31.app.employee.controller.dto.EmployeeDTO;
import com.thinhlh.btvn31.app.employee.domain.services.EmployeeService;
import com.thinhlh.btvn31.base.BaseController;
import com.thinhlh.btvn31.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class EmployeeController extends BaseController {
    private final EmployeeService employeeService;

    @PostMapping("/employee/test")
    private ResponseEntity<BaseResponse<EmployeeDTO>> testEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return successResponse(employeeService.getEmployeeDTO(employeeDTO));
    }
}

package com.thinhlh.btvn13.app.employee.controller;

import com.thinhlh.btvn13.app.employee.controller.dto.CreateEmployeeDTO;
import com.thinhlh.btvn13.app.employee.controller.dto.EmployeeResponse;
import com.thinhlh.btvn13.app.employee.controller.dto.UpdateEmployeeDTO;
import com.thinhlh.btvn13.app.employee.domain.service.EmployeeService;
import com.thinhlh.btvn13.base.BaseController;
import com.thinhlh.btvn13.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity<BaseResponse<List<EmployeeResponse>>> getEmployees() {
        return successResponse(employeeService.getEmployees());
    }

    @GetMapping("/employee/{id}")
    private ResponseEntity<BaseResponse<EmployeeResponse>> getEmployeeById(@PathVariable("id") Long id) {
        return successResponse(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employee/create")
    private ResponseEntity<BaseResponse<EmployeeResponse>> createEmployee(@RequestBody() @Valid() CreateEmployeeDTO createEmployeeDTO) {
        return successResponse(employeeService.createEmployee(createEmployeeDTO));
    }

    @PutMapping("/employee/update/{id}")
    private ResponseEntity<BaseResponse<EmployeeResponse>> updateEmployee(@PathVariable("id") Long id, @RequestBody() UpdateEmployeeDTO updateEmployeeDTO) {
        return successResponse(employeeService.updateEmployee(id, updateEmployeeDTO));
    }

    @DeleteMapping("/employee/delete/{id}")
    private ResponseEntity<BaseResponse<Object>> deleteEmployee(@PathVariable("id") Long id) {
        return successResponse(employeeService.deleteEmployee(id));
    }


}

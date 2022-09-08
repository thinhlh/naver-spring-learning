package com.thinhlh.btvn31.app.department.controller;

import com.thinhlh.btvn31.app.department.controller.dto.DepartmentDTO;
import com.thinhlh.btvn31.app.department.domain.DepartmentService;
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
public class DepartmentController extends BaseController {
    private final DepartmentService departmentService;

    @PostMapping("/department/test")
    private ResponseEntity<BaseResponse<DepartmentDTO>> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        return successResponse(departmentService.getDepartmentDTO(departmentDTO));
    }
}

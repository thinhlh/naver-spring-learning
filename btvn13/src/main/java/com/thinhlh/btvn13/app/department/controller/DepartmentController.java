package com.thinhlh.btvn13.app.department.controller;

import com.thinhlh.btvn13.app.department.controller.dto.CreateDepartmentDTO;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentResponse;
import com.thinhlh.btvn13.app.department.controller.dto.UpdateDepartmentDTO;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.app.department.domain.service.DepartmentService;
import com.thinhlh.btvn13.base.BaseController;
import com.thinhlh.btvn13.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController extends BaseController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    private ResponseEntity<BaseResponse<List<DepartmentMybasticResponse>>> getDepartments() {
        return successResponse(departmentService.getDepartments());
    }

    @GetMapping("/department/{id}")
    private ResponseEntity<BaseResponse<DepartmentResponse>> getDepartmentById(@PathVariable("id") Long id) {
        return successResponse(departmentService.getDepartmentById(id));
    }

    @PostMapping("/department/create")
    private ResponseEntity<BaseResponse<Department>> createDepartment(@RequestBody() @Valid() CreateDepartmentDTO createDepartmentDTO) {
        return successResponse(departmentService.createDepartment(createDepartmentDTO));
    }

    @PutMapping("/department/update/{id}")
    private ResponseEntity<BaseResponse<Department>> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody() UpdateDepartmentDTO updateDepartmentDTO) {
        return successResponse(departmentService.updateDepartment(departmentId, updateDepartmentDTO));
    }


    @DeleteMapping("/department/delete/{id}")
    private ResponseEntity<BaseResponse<Object>> deleteDepartment(@PathVariable() Long id) {
        return successResponse(departmentService.deleteDepartment(id));
    }
}

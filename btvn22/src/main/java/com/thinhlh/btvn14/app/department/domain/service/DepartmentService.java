package com.thinhlh.btvn14.app.department.domain.service;

import com.thinhlh.btvn14.app.department.controller.dto.CreateDepartmentDTO;
import com.thinhlh.btvn14.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn14.app.department.controller.dto.DepartmentResponse;
import com.thinhlh.btvn14.app.department.controller.dto.UpdateDepartmentDTO;
import com.thinhlh.btvn14.app.department.domain.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentMybasticResponse> getDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentMybasticResponse getDepartmentByIdWithTotalEmployees(Long id);

    Department createDepartment(CreateDepartmentDTO createDepartmentDTO);

    Department updateDepartment(Long id, UpdateDepartmentDTO department);

    Object deleteDepartment(Long id);
}

package com.thinhlh.btvn13.app.department.domain.service;

import com.thinhlh.btvn13.app.department.controller.dto.CreateDepartmentDTO;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentResponse;
import com.thinhlh.btvn13.app.department.controller.dto.UpdateDepartmentDTO;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.exceptions.NotFoundException;

import java.util.List;

public interface DepartmentService {
    List<DepartmentMybasticResponse> getDepartments();

    DepartmentResponse getDepartmentById(Long id);

    Department createDepartment(CreateDepartmentDTO createDepartmentDTO);

    Department updateDepartment(Long id, UpdateDepartmentDTO department);

    Object deleteDepartment(Long id);
}

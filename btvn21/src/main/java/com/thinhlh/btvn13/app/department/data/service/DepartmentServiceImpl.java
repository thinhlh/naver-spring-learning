package com.thinhlh.btvn13.app.department.data.service;

import com.thinhlh.btvn13.app.department.controller.dto.CreateDepartmentDTO;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn13.app.department.controller.dto.DepartmentResponse;
import com.thinhlh.btvn13.app.department.controller.dto.UpdateDepartmentDTO;
import com.thinhlh.btvn13.app.department.data.repository.DepartmentMybasticRepository;
import com.thinhlh.btvn13.app.department.data.repository.DepartmentRepository;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.app.department.domain.service.DepartmentService;
import com.thinhlh.btvn13.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.thinhlh.btvn13.config.constants.MessageConstants.DEPARTMENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final ModelMapper mapper = new ModelMapper();


    private final DepartmentRepository departmentRepository;

    @Resource
    private final DepartmentMybasticRepository departmentMybasticRepository;

    @Override
    public List<DepartmentMybasticResponse> getDepartments() {
        return departmentMybasticRepository.getDepartments();
//        return departmentRepository.findAll();
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        var department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return mapper
                    .typeMap(Department.class, DepartmentResponse.class)
                    .map(department.get());
        } else {
            throw new NotFoundException(DEPARTMENT_NOT_FOUND);
        }
    }

    @Override
    public Department createDepartment(CreateDepartmentDTO createDepartmentDTO) {

        Department department = mapper
                .typeMap(CreateDepartmentDTO.class, Department.class)
                .addMapping(CreateDepartmentDTO::getDepartmentName, Department::setDeptName)
                .map(createDepartmentDTO);

        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, UpdateDepartmentDTO updateDepartmentDTO) {

        var department = departmentRepository.findById(id).orElse(null);

        if (department != null) {

            if (updateDepartmentDTO.getDepartmentName() != null)
                department.setDeptName(updateDepartmentDTO.getDepartmentName());
            if (updateDepartmentDTO.getDescription() != null)
                department.setDescription(updateDepartmentDTO.getDescription());

            return departmentRepository.save(department);
        } else {
            throw new NotFoundException(DEPARTMENT_NOT_FOUND);
        }
    }

    @Override
    public Object deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return null;
        } else {
            throw new NotFoundException(DEPARTMENT_NOT_FOUND);
        }
    }
}

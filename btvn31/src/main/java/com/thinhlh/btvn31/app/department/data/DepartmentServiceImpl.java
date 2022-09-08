package com.thinhlh.btvn31.app.department.data;

import com.thinhlh.btvn31.app.department.controller.dto.DepartmentDTO;
import com.thinhlh.btvn31.app.department.domain.DepartmentService;
import com.thinhlh.btvn31.base.BaseService;
import com.thinhlh.btvn31.config.resources.Constants;
import com.thinhlh.btvn31.config.resources.Messages;
import com.thinhlh.btvn31.exceptions.DuplicatedResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl extends BaseService implements DepartmentService {

    private final Messages messages;
    private final Constants constants;

    @Override
    public DepartmentDTO getDepartmentDTO(DepartmentDTO departmentDTO) {
        logger.info("Executing getDepartmentDTO with argument: " + departmentDTO.toString());
        if (
                departmentDTO
                        .getDeptName()
                        .equals(constants.getForbiddenName())
                        || departmentDTO
                        .getEmployees()
                        .stream()
                        .anyMatch(employeeDTO -> employeeDTO
                                .getName()
                                .equals(constants.getForbiddenName())
                        )
        )
            throw new DuplicatedResourceException(messages.getDuplicatedName());
        return departmentDTO;
    }
}

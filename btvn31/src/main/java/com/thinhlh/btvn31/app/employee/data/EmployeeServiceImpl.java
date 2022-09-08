package com.thinhlh.btvn31.app.employee.data;

import com.thinhlh.btvn31.app.employee.controller.dto.EmployeeDTO;
import com.thinhlh.btvn31.app.employee.domain.services.EmployeeService;
import com.thinhlh.btvn31.base.BaseService;
import com.thinhlh.btvn31.config.resources.Constants;
import com.thinhlh.btvn31.config.resources.Messages;
import com.thinhlh.btvn31.exceptions.DuplicatedResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

    private final Messages messages;
    private final Constants constants;

    @Override
    public EmployeeDTO getEmployeeDTO(EmployeeDTO employeeDTO) {
        logger.info(getClass().getName() + "-" + employeeDTO.toString());
        if (employeeDTO.getName().equals(constants.getForbiddenName()))
            throw new DuplicatedResourceException(messages.getDuplicatedName());
        return employeeDTO;
    }
}

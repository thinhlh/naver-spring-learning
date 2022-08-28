package com.thinhlh.btvn14.app.employee.data.service;

import com.thinhlh.btvn14.app.department.data.repository.DepartmentRepository;
import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.department.domain.service.DepartmentService;
import com.thinhlh.btvn14.app.employee.controller.dto.CreateEmployeeDTO;
import com.thinhlh.btvn14.app.employee.controller.dto.EmployeeMybasticResponse;
import com.thinhlh.btvn14.app.employee.controller.dto.EmployeeResponse;
import com.thinhlh.btvn14.app.employee.controller.dto.UpdateEmployeeDTO;
import com.thinhlh.btvn14.app.employee.data.repository.EmployeeMybasticRepository;
import com.thinhlh.btvn14.app.employee.data.repository.EmployeeRepository;
import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import com.thinhlh.btvn14.app.employee.domain.service.EmployeeService;
import com.thinhlh.btvn14.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Source;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.thinhlh.btvn14.config.constants.MessageConstants.DEPARTMENT_NOT_FOUND;
import static com.thinhlh.btvn14.config.constants.MessageConstants.EMPLOYEE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    @Source
    private final EmployeeMybasticRepository employeeMybasticRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final TypeMap<Employee, EmployeeResponse> employeeToResponseMapper = new ModelMapper().typeMap(Employee.class, EmployeeResponse.class);

    @Override
    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAll().stream().map(employeeToResponseMapper::map).toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        var employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return mapper.typeMap(Employee.class, EmployeeResponse.class).map(employee.get());
        } else {
            throw new NotFoundException(EMPLOYEE_NOT_FOUND);
        }
    }

    @Override
    public EmployeeMybasticResponse getEmployeeMybastic(Long id) {
        var employee = employeeMybasticRepository.getEmployeeById(id);

        if (employee != null) {
            return employee;
        } else {
            throw new NotFoundException(EMPLOYEE_NOT_FOUND);
        }
    }

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        var employee =
                mapper
                        .typeMap(CreateEmployeeDTO.class, Employee.class)
                        .map(createEmployeeDTO);


        var departmentOfEmployee = departmentService.getDepartmentById(createEmployeeDTO.getDepartmentId());
        employee.setDepartment((Department) departmentOfEmployee);
        return employeeToResponseMapper.map(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, UpdateEmployeeDTO updateEmployeeDTO) {
        var employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {

            if (updateEmployeeDTO.getName() != null)
                employee.setName(updateEmployeeDTO.getName());
            if (updateEmployeeDTO.getBirthday() != null)
                employee.setBirthday(updateEmployeeDTO.getBirthday());
            if (updateEmployeeDTO.getGender() != null)
                employee.setGender(updateEmployeeDTO.getGender());
            if (updateEmployeeDTO.getDepartmentId() != null) {
                Department departmentOfEmployee = departmentRepository.findById(updateEmployeeDTO.getDepartmentId()).orElse(null);
                if (departmentOfEmployee != null)
                    employee.setDepartment(departmentOfEmployee);
                else
                    throw new NotFoundException(DEPARTMENT_NOT_FOUND);
            }

            return employeeToResponseMapper.map(employeeRepository.save(employee));
        } else {
            throw new NotFoundException(EMPLOYEE_NOT_FOUND);
        }
    }

    @Override
    public Object deleteEmployee(Long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return null;
        } else {
            throw new NotFoundException(EMPLOYEE_NOT_FOUND);
        }
    }
}

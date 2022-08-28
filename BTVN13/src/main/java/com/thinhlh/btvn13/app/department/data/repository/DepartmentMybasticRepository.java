package com.thinhlh.btvn13.app.department.data.repository;

import com.thinhlh.btvn13.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.app.employee.domain.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DepartmentMybasticRepository {

    @Select("Select * from DEPARTMENT")
    @Results(value = {
            @Result(property = "id", column = "department_id"),
            @Result(property = "duntknow", column = "department_id"),
            @Result(property = "departmentName", column = "dept_name"),
            @Result(property = "employees", column = "department_id",javaType = List.class, many = @Many(select = "getEmployeeByDepartmentId"))
    })
    @Options()
    List<DepartmentMybasticResponse> getDepartments();

    @Select("Select * from Employee where department_id=#{departmentId}")
    @Results(value = {
            @Result(property = "employeeId",column = "employee_id"),
    })
    List<Employee> getEmployeeByDepartmentId(Long departmentId);
}

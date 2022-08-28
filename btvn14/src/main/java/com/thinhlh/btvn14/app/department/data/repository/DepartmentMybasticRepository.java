package com.thinhlh.btvn14.app.department.data.repository;

import com.thinhlh.btvn14.app.department.controller.dto.DepartmentMybasticResponse;
import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMybasticRepository {

    @Select("Select * from DEPARTMENT")
    @Results(value = {
            @Result(property = "id", column = "department_id"),
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


    @Select("Select COUNT(E.employee_id) as total, D.dept_name as name, D.department_id as id, D.description as description " +
            "from department D join employee E on D.department_id = E.department_id " +
            "where D.department_id=#{departmentId}"
    )
    @Results(
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "departmentName", column = "name"),
                    @Result(property = "totalEmployees",column = "total"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "employees", column = "id", javaType = List.class, many = @Many(select = "getEmployeeByDepartmentId"))
            }
    )
    DepartmentMybasticResponse getDepartmentById(Long departmentId);
}

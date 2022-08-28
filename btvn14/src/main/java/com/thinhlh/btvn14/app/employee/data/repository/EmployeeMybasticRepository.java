package com.thinhlh.btvn14.app.employee.data.repository;

import com.thinhlh.btvn14.app.department.domain.entity.Department;
import com.thinhlh.btvn14.app.employee.controller.dto.EmployeeMybasticResponse;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMybasticRepository {

    @Select("SELECT E.* FROM Employee E join Department D on E.department_id = D.department_id where E.employee_id = #{id}")

    @Results(value = {
            @Result(property = "id", column = "employee_id"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "name", column = "name"),
            @Result(property = "department", column = "department_id", javaType = Department.class, one = @One(select = "getDepartment"))
    })
    EmployeeMybasticResponse getEmployeeById(Long id);

    @Select("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = #{id}")
    @Results(value = {
            @Result(property = "departmentId", column = "department_id"),
            @Result(property = "deptName", column = "dept_name")
    })
    Department getDepartment(Long id);
}

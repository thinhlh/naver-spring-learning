package com.thinhlh.btvn14.app.employee.data.repository;

import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.thinhlh.btvn14.app.department.data.repository;

import com.thinhlh.btvn14.app.department.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

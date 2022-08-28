package com.thinhlh.btvn13.app.department.data.repository;

import com.thinhlh.btvn13.app.department.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

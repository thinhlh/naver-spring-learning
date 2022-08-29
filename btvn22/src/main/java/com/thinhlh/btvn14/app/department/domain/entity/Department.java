package com.thinhlh.btvn14.app.department.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinhlh.btvn14.app.employee.domain.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    private Long departmentId;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", orphanRemoval = true)
    private List<Employee> employees = new java.util.ArrayList<>();
}

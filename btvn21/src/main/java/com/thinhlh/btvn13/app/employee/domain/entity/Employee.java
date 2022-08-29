package com.thinhlh.btvn13.app.employee.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinhlh.btvn13.app.department.domain.entity.Department;
import com.thinhlh.btvn13.helpers.DateTimeHelper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Long employeeId;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ManyToOne()
    @JoinColumn(name = "departmentId")
    @JsonIgnore
    private Department department;
}

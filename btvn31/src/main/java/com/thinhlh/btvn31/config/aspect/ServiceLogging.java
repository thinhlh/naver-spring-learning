package com.thinhlh.btvn31.config.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
@Log4j2
public class ServiceLogging {


    @Before("execution(* com.thinhlh.btvn31.app.department.data.DepartmentServiceImpl.getDepartmentDTO(..))")
    void beforeGetDepartmentDTO(JoinPoint joinPoint) {
        log.info("Before executing getDepartmentDTO");
    }

    @After("execution(* com.thinhlh.btvn31.app.department.data.DepartmentServiceImpl.getDepartmentDTO(..))")
    void afterGetDepartmentDTO(JoinPoint joinPoint) {
        log.info("After executing getDepartmentDTO");
    }

    @AfterThrowing("execution(* com.thinhlh.btvn31.app.employee.data.EmployeeServiceImpl.getEmployeeDTO(..))")
    void afterGetEmployeeDTO(JoinPoint joinPoint) {
        log.error("Executing getEmployeeDTO unsuccessfully!");
    }
}

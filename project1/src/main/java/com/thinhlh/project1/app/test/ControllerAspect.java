package com.thinhlh.project1.app.test;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Log4j2
public class ControllerAspect {
    @Before("execution(* com.thinhlh.project1.app.test.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("At file: " + joinPoint.getSourceLocation().getFileName() + " function name: " + joinPoint.getSignature().getName());
    }
}

package com.example.congespring.Config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.example.congespring.Controller.*.*(..))", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: {}. Exception: {}", joinPoint.getSignature().getName(), exception.getMessage());
    }
}

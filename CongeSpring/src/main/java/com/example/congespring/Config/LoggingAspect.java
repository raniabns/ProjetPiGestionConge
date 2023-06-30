package com.example.congespring.Config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning("execution(* com.example.congespring.Service.DemandeCongeService.faireDemandeConge(..))")
    public void logAfterAjouterDemandeConge() {
        System.out.println("Méthode ajouterdemandeConge() exécutée avec succès.");
    }
    @Before("execution(* com.example.congespring.Controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.congespring.Controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("After method: {}. Result: {}", joinPoint.getSignature().getName(), result);
    }
}

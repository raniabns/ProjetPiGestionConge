package com.example.congespring.Config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @AfterReturning("execution(* com.example.congespring.Service.DemandeCongeService.faireDemandeConge(..))")
    public void logAfterAjouterDemandeConge() {
        System.out.println("Méthode ajouterdemandeConge() exécutée avec succès.");
    }
}

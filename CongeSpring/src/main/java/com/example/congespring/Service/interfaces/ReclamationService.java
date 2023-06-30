package com.example.congespring.Service.interfaces;

import com.example.congespring.Entity.Reclamation;
import java.util.List;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Aspect
@Service
public interface ReclamationService {

    List<Reclamation> retrieveAllReclamations();
    Reclamation addReclamation(Reclamation r);
    Reclamation updateReclamation(Long idRecalamation,Reclamation r);
    Reclamation retrieveReclamationById(Long id);
    String deleteReclamation(Long id);


    void deleteExpiredReclamations();
}

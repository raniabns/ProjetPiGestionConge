package com.example.congespring.Service;

import com.example.congespring.Entity.Reclamation;
import com.example.congespring.Entity.TypeReclamation;

import java.util.List;
public interface ReclamationService {
    List<Reclamation> retrieveAllReclamations();

    Reclamation addReclamation(Reclamation r);

    String deleteReclamation(Long id);

    Reclamation updateReclamation(Reclamation r);

    Reclamation retrieveReclamation(Long id);


}
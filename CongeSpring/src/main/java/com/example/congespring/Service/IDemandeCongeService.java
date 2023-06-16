package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;

import java.util.List;

public interface IDemandeCongeService {
    DemandeConge ajouterdemandeConge(DemandeConge c);
   DemandeConge modifierdemandeConge(Long idConge,DemandeConge c);
   List <DemandeConge> AfficheDemandeConge();
   void supprimerDemandeConge(Long idConge) ;
    boolean verifierSoldeConge(long idUser, Long duree);
    boolean verifierPresenceEquipe(long employeId);
    boolean existeEvenementEntreprise();
    boolean faireDemandeConge(DemandeConge demandeConge,Long idUser);
    }



package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;

import java.util.List;

public interface IDemandeCongeService {
    DemandeConge ajouterdemandeConge(DemandeConge c);
   DemandeConge modifierdemandeConge(long idConge,DemandeConge c);
   List <DemandeConge> AfficheDemandeConge();
   void supprimerDemandeConge(long idConge) ;
    boolean verifierSoldeConge(long idUser, long duree);
   boolean verifierPresenceCollaborateurs(long idEquipe);

    boolean existeEvenementEntreprise();
    boolean faireDemandeConge(DemandeConge demandeConge,long idUser,long idEquipe);
     DemandeConge RetrouverDemandeConge(long  idConge);
    
    int calculerSoldeConge(Long userId);

    DemandeConge accepterDemandeConge(Long demandeCongeId);

    DemandeConge refuserDemandeConge(Long demandeCongeId);

}



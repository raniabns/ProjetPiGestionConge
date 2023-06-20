package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;

import java.util.List;

public interface IDemandeCongeService {
    DemandeConge ajouterdemandeConge(DemandeConge c);
   DemandeConge modifierdemandeConge(long idConge,DemandeConge c);
   List <DemandeConge> AfficheDemandeConge();
   void supprimerDemandeConge(long idConge) ;
    boolean verifierSoldeConge(long idUser, long duree);
    boolean verifierPresenceEquipe(long idEquipe);
    boolean existeEvenementEntreprise();
    boolean faireDemandeConge(DemandeConge demandeConge,long idUser);
    }



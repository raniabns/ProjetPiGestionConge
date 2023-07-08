package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDemandeCongeService {
    DemandeConge ajouterdemandeConge(DemandeConge c);
   DemandeConge modifierdemandeConge(long idConge,DemandeConge c);
   List <DemandeConge> AfficheDemandeConge();
   void supprimerDemandeConge(long idConge) ;
    boolean verifierSoldeConge(long idUser, long duree);
   boolean verifierPresenceCollaborateurs(long idEquipe);


    boolean faireDemandeConge(DemandeConge demandeConge, long idUser, long idEquipe);
     DemandeConge RetrouverDemandeConge(long  idConge);
    }



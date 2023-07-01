package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.Equipe;
import com.example.congespring.Entity.User;
import com.example.congespring.Repository.IEquipe;
import com.example.congespring.Repository.IUser;
import com.example.congespring.Repository.IDemandeConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class DemandeCongeService implements IDemandeCongeService {
    @Autowired
    IDemandeConge idemandeConge;
    @Autowired
    IUser iuser;
    @Autowired
    IEquipe iEquipe;

    @Override
    public DemandeConge ajouterdemandeConge(DemandeConge c) {
        return
                idemandeConge.save(c);
    }

    @Override
    public boolean verifierSoldeConge(long idUser, long duree) {
        // Vérifier le solde de congé de l'employé et la durée de congé demandée

        User user = iuser.findById(idUser).orElse(null);

        if (user != null) {
            int soldeConge = user.getSoldeconge();

            if (duree <= soldeConge) {
                return true;
            }
        }

        return false;
    }



    @Override
    public boolean verifierPresenceCollaborateurs(long idEquipe) {
        Equipe equipe = iEquipe.findById(idEquipe).orElse(null);
        if (equipe == null) {
            // L'équipe n'existe pas
            return false;
        }

        int nombreCollaborateurs = equipe.getUsers().size();
        int seuilPresence = (int) Math.ceil(nombreCollaborateurs * 0.2); // 20% arrondi supérieur

        int nombreCollaborateursPresent = 0;
        for (User user : equipe.getUsers()) {
            boolean estAuTravail = false; // Indicateur pour vérifier si le collaborateur est au travail
            for (DemandeConge demandeConge : user.getConges()) {
                if (demandeConge.estAuTravail()) {
                    estAuTravail = true;
                    break; // Sortir de la boucle si le collaborateur est au travail
                }
            }
            if (estAuTravail) {
                nombreCollaborateursPresent++;
            }
        }

        return nombreCollaborateursPresent >= seuilPresence;
    }

    @Override
    public boolean existeEvenementEntreprise() {
        return false;
    }


@Override
    public boolean faireDemandeConge(DemandeConge demandeConge,long idUser,long idEquipe) {
        // Vérifier le solde de congé de l'employé
    User user = iuser.findById(idUser).orElse(null);
    if (user == null || !verifierSoldeConge(idUser, demandeConge.getDuree())) {
        return false;}
    if (!verifierPresenceCollaborateurs(idEquipe)){
        return  false;
    }


        // Vérifier l'absence d'événement dans l'entreprise
       /* if (existeEvenementEntreprise()) {
            return false;
        }*/

        // Effectuer d'autres vérifications spécifiques si nécessaire

        // Soumettre la demande de congé
        idemandeConge.save(demandeConge);

        return true;
    }

    @Override
    public DemandeConge modifierdemandeConge(long idConge, DemandeConge c) {
        DemandeConge d = idemandeConge.findById(idConge).get();

        d.setDateDebut(c.getDateDebut());
        d.setDateFin(c.getDateFin());
        d.setType(c.getType());
        d.setDuree(c.getDuree());
        return idemandeConge.save(c);
    }
    @Override
    public List<DemandeConge> AfficheDemandeConge() {
        List<DemandeConge> conges= (List<DemandeConge>) idemandeConge.findAll();
        return conges;
    }
    @Override
    public DemandeConge RetrouverDemandeConge(long  idConge){
   return idemandeConge.findById(idConge).get();
    }
   {

    }

@Override
public void supprimerDemandeConge(long idConge) {
    idemandeConge.deleteById(idConge);
}


    @Override
    public int calculerSoldeConge(Long userId) {
        User user = iuser.findById(userId).orElse(null);
        if (user != null) {
            int soldeConge = user.getSoldeconge(); // Obtenez le solde de congé actuel de l'utilisateur
            LocalDate currentDate = LocalDate.now(); // Obtenez la date actuelle
            int monthsSinceJoining = Period.between(user.getDateJoining(), currentDate).getMonths(); // Calcule le nombre de mois écoulés depuis l'adhésion de l'utilisateur

            // Ajoutez 2 jours de congé pour chaque mois écoulé
            int joursAjoutes = monthsSinceJoining * 2;
            soldeConge += joursAjoutes;

            return soldeConge;
        }
        return 0;
    }

    @Override
    public DemandeConge accepterDemandeConge(Long demandeCongeId) {
    Optional<DemandeConge> optionalDemandeConge = demandeCongeRepository.findById(demandeCongeId);
    if (optionalDemandeConge.isPresent()) {
        DemandeConge demandeConge = optionalDemandeConge.get();
        
        // Vérifier la disponibilité du solde de congé
        int soldeConge = demandeConge.getUser().getSoldeConge();
        if (soldeConge > 0) {
            demandeConge.setEtatDemande("Acceptée");
            return demandeCongeRepository.save(demandeConge);
        } else {
            // Si le solde de congé est insuffisant, vous pouvez définir l'état de la demande comme "Refusée"
            demandeConge.setEtatDemande("Refusée");
            return demandeCongeRepository.save(demandeConge);
        }
    }
    return null;
    }

    @Override
    public DemandeConge refuserDemandeConge(Long demandeCongeId) {
        Optional<DemandeConge> optionalDemandeConge = idemandeCongeRepository.findById(demandeCongeId);
        if (optionalDemandeConge.isPresent()) {
            DemandeConge demandeConge = optionalDemandeConge.get();
            demandeConge.setEtatDemande("Refusée");
            return idemandeCongeRepository.save(demandeConge);
        }
        return null;
    }


}

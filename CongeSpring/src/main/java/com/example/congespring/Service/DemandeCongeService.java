package com.example.congespring.Service;

import com.example.congespring.Entity.*;
import com.example.congespring.Repository.IEquipe;
import com.example.congespring.Repository.IUser;
import com.example.congespring.Repository.IDemandeConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public boolean faireDemandeConge(DemandeConge demandeConge,long idUser,long idEquipe) {
    // Vérifier le solde de congé de l'employé
    User user = iuser.findById(idUser).orElse(null);

    if (user == null || !verifierSoldeConge(idUser, demandeConge.getDuree())) {
        return false;
    }
    if (!verifierPresenceCollaborateurs(idEquipe)) {
        return false;

    }


    demandeConge.setUser(user);
    idemandeConge.save(demandeConge);

        return true;
    }

    @Override
    public DemandeConge modifierdemandeConge(long idConge, DemandeConge c) {
        DemandeConge d = idemandeConge.findById(idConge).orElse(null);

        if (d != null) {
            // Mise à jour des propriétés spécifiées dans l'objet c
            if (c.getDateDebut() != null) {
                d.setDateDebut(c.getDateDebut());
            }
            if (c.getDateFin() != null) {
                d.setDateFin(c.getDateFin());
            }
            if (c.getType() != null) {
                d.setType(c.getType());
            }
            if (c.getDuree() != null) {
                d.setDuree(c.getDuree());
            }

            return idemandeConge.save(d);
        }return null;}

    @Override
    public List<DemandeConge> AfficheDemandeConge() {
        return  idemandeConge.findAll();
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



}

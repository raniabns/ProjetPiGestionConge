package com.example.congespring.Service;

import com.example.congespring.Entity.User;
import com.example.congespring.Repository.IDemandeConge;
import com.example.congespring.Repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUser iUser;
    @Autowired
    IDemandeConge iDemandeConge;

   @Override
    public User mettreAJourSoldeConge(Long idUser) {
        User user = iUser.findById(idUser).orElse(null);
        if (user != null) {
            int soldedeConge = user.getSoldeCongeInitial() - user.getSoldeCongeApris();
            user.setSoldeconge(soldedeConge);
           iUser.save(user);
        }

        return user;
    }
    @Scheduled(cron = "0 0 0 1 * ?") // Exécution tous les mois, le premier jour du mois à minuit
    public void mettreAJourSoldeCongePourTousLesUtilisateurs() {
        // Récupérer la liste de tous les utilisateurs
        List<User> utilisateurs = iUser.findAll();

        // Parcourir les utilisateurs et mettre à jour leur solde de congé
        for (User utilisateur : utilisateurs) {
            mettreAJourSoldeConge(utilisateur.getIdUser());
        }
    }
}




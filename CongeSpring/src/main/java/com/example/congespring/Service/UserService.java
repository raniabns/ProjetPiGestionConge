package com.example.congespring.Service;

import com.example.congespring.Entity.User;
import com.example.congespring.Repository.IDemandeConge;
import com.example.congespring.Repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUser iUser;
    @Autowired
    IDemandeConge iDemandeConge;

   @Override
    public User mettreAJourSoldeConge(Long idUser, int soldeconge) {
        User user = iUser.findById(idUser).orElse(null);
        if (user != null) {
            int soldeCongeUtilise = user.getSoldeCongeInitial() - user.getSoldeCongeDisponible();
            int soldeConge =soldeconge - soldeCongeUtilise;
            user.setSoldeconge((long) soldeConge);
           iUser.save(user);
        }

        return user;
    }
}

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
    public User mettreAJourSoldeConge(Long idUser) {
        User user = iUser.findById(idUser).orElse(null);
        if (user != null) {
            int soldedeConge = user.getSoldeCongeInitial() - user.getSoldeCongeApris();
            user.setSoldeconge(soldedeConge);
           iUser.save(user);
        }

        return user;
    }


}

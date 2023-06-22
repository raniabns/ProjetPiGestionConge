package com.example.congespring.Controller;

import com.example.congespring.Entity.User;
import com.example.congespring.Repository.IUser;
import com.example.congespring.Service.IDemandeCongeService;
import com.example.congespring.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Utilisateur")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    public IDemandeCongeService iDemandeCongeservice;
    @Autowired
    public IUserService iUserService;
    @PostMapping("/ajoutsoldeconge/{idUser}")
    @ResponseBody
    public User mettreAJourSoldeConge(@PathVariable("idUser") Long idUser){
        return iUserService.mettreAJourSoldeConge(idUser);
    }

    @PostMapping("/update-solde-conge-tous")
    public ResponseEntity<String> mettreAJourSoldeCongePourTousLesUtilisateurs() {
        iUserService.mettreAJourSoldeCongePourTousLesUtilisateurs();
        return ResponseEntity.ok("Mise à jour du solde de congé effectuée avec succès.");
    }

}

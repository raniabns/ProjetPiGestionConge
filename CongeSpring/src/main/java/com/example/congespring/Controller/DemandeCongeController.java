package com.example.congespring.Controller;

import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.TypeConge;
import com.example.congespring.Service.IDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DemandeConge")
@CrossOrigin(origins = "*")
public class DemandeCongeController {
    @Autowired
    public IDemandeCongeService iDemandeCongeservice;

    @PostMapping("/ajoutconge")
    @ResponseBody
    public DemandeConge ajouterdemandeConge(@RequestBody DemandeConge c) {
        return iDemandeCongeservice.ajouterdemandeConge(c);

    }

    @GetMapping("/allDemandeConge")
    public List<DemandeConge> AfficheDemandeConge(@RequestBody List<DemandeConge> conges) {
        return iDemandeCongeservice.AfficheDemandeConge();
    }

    @PutMapping("/modifconge/{idConge}")
    public DemandeConge modifierdemandeConge(@PathVariable("idConge") Long idConge, @RequestBody DemandeConge c) {
        return iDemandeCongeservice.modifierdemandeConge(idConge, c);
    }

    @DeleteMapping("/{idConge}")
    public void supprimerDemandeConge(@PathVariable("idConge") Long idConge) {
        iDemandeCongeservice.supprimerDemandeConge(idConge);

    }

    @GetMapping("/{idEquipe}/presence")
    public  boolean verifierPresenceEquipe(@PathVariable("idEquipe") Long idEquipe){

       return  iDemandeCongeservice.verifierPresenceEquipe(idEquipe);
    }
    @GetMapping("/verifier-solde-conge/{idUser}/{duree}")
    public boolean verifierSoldeConge(@PathVariable("idUser") long idUser, @PathVariable("duree")Long duree) {

        // Vérifier le solde de congé
        return iDemandeCongeservice.verifierSoldeConge(idUser, duree);
    }

    @PostMapping("/demandes/{idUser}")
    public ResponseEntity<String> faireDemandeConge(@RequestBody DemandeConge demandeConge,@PathVariable("idUser") Long idUser) {
        boolean soldeSuffisant = iDemandeCongeservice.verifierSoldeConge(idUser, demandeConge.getDuree());

        if (!soldeSuffisant) {
            return ResponseEntity.badRequest().body("Le solde de congé est insuffisant.");
        }

        boolean demandeAcceptee = iDemandeCongeservice.faireDemandeConge(demandeConge,idUser);
        if (demandeAcceptee) {
            return ResponseEntity.ok("Demande de congé créée avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Impossible de créer la demande de congé.");
        }
    }
}
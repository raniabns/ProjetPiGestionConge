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
    public List<DemandeConge> AfficheDemandeConge() {
        return iDemandeCongeservice.AfficheDemandeConge();
        }
    @GetMapping("/TrouverUnedemandeConge/{idConge}")
    public DemandeConge RetrouverDemandeConge(@PathVariable("idConge")long  idConge){
        return iDemandeCongeservice.RetrouverDemandeConge(idConge);
    }

    @PutMapping("/modifconge/{idConge}")
    public DemandeConge modifierdemandeConge(@PathVariable("idConge") long idConge, @RequestBody DemandeConge c) {
        return iDemandeCongeservice.modifierdemandeConge(idConge, c);
    }

    @DeleteMapping("/{idConge}")
    public void supprimerDemandeConge(@PathVariable("idConge") long idConge) {
        iDemandeCongeservice.supprimerDemandeConge(idConge);

    }

    @GetMapping("/{idEquipe}/presence")
    public  boolean verifierPresenceCollaborateurs(@PathVariable("idEquipe") long idEquipe){

      return  iDemandeCongeservice.verifierPresenceCollaborateurs(idEquipe);
    }
    @GetMapping("/verifier-solde-conge/{idUser}/{duree}")
    public boolean verifierSoldeConge(@PathVariable("idUser") long idUser, @PathVariable("duree")long duree) {

        // Vérifier le solde de congé
        return iDemandeCongeservice.verifierSoldeConge(idUser, duree);
    }

    @PostMapping("/demandes/{idUser}/{idEquipe}")
    public ResponseEntity<String> faireDemandeConge(@RequestBody DemandeConge demandeConge,@PathVariable("idUser") long idUser,@PathVariable("idEquipe")long idEquipe) {
        boolean soldeSuffisant = iDemandeCongeservice.verifierSoldeConge(idUser, demandeConge.getDuree());

        if (!soldeSuffisant) {
            return ResponseEntity.badRequest().body("Le solde de congé est insuffisant.");
        }
        boolean presencecollaborateur = iDemandeCongeservice.verifierPresenceCollaborateurs(idEquipe);

        if (!presencecollaborateur) {
            return ResponseEntity.badRequest().body("moins de 20% present dans l'equipe.");
        }


        boolean demandeAcceptee = iDemandeCongeservice.faireDemandeConge(demandeConge,idUser,idEquipe);
        if (demandeAcceptee) {
            return ResponseEntity.ok("Demande de congé créée avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Impossible de créer la demande de congé.");
        }
    }
}
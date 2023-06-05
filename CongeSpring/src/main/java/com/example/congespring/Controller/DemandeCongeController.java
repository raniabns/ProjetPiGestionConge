package com.example.congespring.Controller;

import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.TypeConge;
import com.example.congespring.Service.IDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DemandeConge")
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
    public DemandeConge modifierdemandeConge(@PathVariable("idConge") Long idConge,@RequestBody DemandeConge c)
    {return iDemandeCongeservice.modifierdemandeConge(idConge,c);
    }
    @DeleteMapping("/{idConge}")
    public void supprimerDemandeConge(@PathVariable ("idConge") Long idConge) {
       iDemandeCongeservice.supprimerDemandeConge(idConge);

    }
}


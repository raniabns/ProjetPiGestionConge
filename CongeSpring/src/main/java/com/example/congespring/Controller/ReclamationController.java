package com.example.congespring.Controller;
import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.Reclamation;
import com.example.congespring.Repository.ReclamationRepository;
import com.example.congespring.Service.interfaces.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/recalamation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;
    @Autowired
    ReclamationRepository rp;
    @GetMapping("/GetAllReclamations")
    @ResponseBody
    public List<Reclamation> getReclamations() {
        List<Reclamation> listReclamations = reclamationService.retrieveAllReclamations();
        return listReclamations;
    }
    @PostMapping("/AddReclamation")
    @ResponseBody
    public Reclamation addStock(@RequestBody Reclamation r)
    {
        Reclamation reclamation = reclamationService.addReclamation(r);
        return reclamation;
    }
    @PutMapping("/UpdateReclamation/{idReclamation}")
    public Reclamation updateReclamation( @PathVariable("idReclamation") Long idReclamation, @RequestBody Reclamation r)
    {return reclamationService.updateReclamation(idReclamation,r);
    }
    @GetMapping("/GetReclamation/{idReclamation}")
    @ResponseBody
    public Reclamation findReclamation(@PathVariable("idReclamation")Long i) {

        return reclamationService.retrieveReclamationById(i);
    }
    @DeleteMapping("/DeleteReclamation/{id}")
    public String deleteReclamation(@PathVariable long id) {
        return reclamationService.deleteReclamation(id);
    }
}

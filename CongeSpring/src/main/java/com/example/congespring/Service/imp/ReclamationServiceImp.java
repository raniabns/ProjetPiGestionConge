package com.example.congespring.Service.imp;
import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.Reclamation;
import com.example.congespring.Repository.ReclamationRepository;
import com.example.congespring.Service.interfaces.ReclamationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Aspect
@Slf4j
@Service
public class ReclamationServiceImp implements ReclamationService {
    @Autowired
    ReclamationRepository Reclamationrepository;

    @Override
    public List<Reclamation> retrieveAllReclamations() {
        ArrayList<Reclamation> r=new ArrayList<Reclamation>();
        Reclamationrepository.findAll().forEach(rec->r.add(rec));
        for(Reclamation s : r) {
            log.info("list reclamation"+s);
        }

        return r;
    }

    @Override
    public Reclamation addReclamation(Reclamation r) {
        return Reclamationrepository.save(r);
    }



    @Override
    public Reclamation updateReclamation(Long idRecalamation,Reclamation r) {
        Reclamation rc = Reclamationrepository.findById(idRecalamation).get();
        rc.setTitre(r.getTitre());
        rc.setDescription(r.getDescription());
        rc.setCategorie(r.getCategorie());
        return Reclamationrepository.save(r);

    }

    @Override
    public Reclamation retrieveReclamationById(Long id) {
        return Reclamationrepository.findById(id).get();
    }

    @Override
    public  String deleteReclamation(Long id) {

        Reclamationrepository.deleteById(id);
        return ("Reclamation " +id +" deleted") ;


    }
}

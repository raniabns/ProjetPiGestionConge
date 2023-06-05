package com.example.congespring.Service;

import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Repository.IUser;
import com.example.congespring.Repository.IDemandeConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeCongeService implements IDemandeCongeService {
    @Autowired
    private IDemandeConge demandeConge;
    @Autowired
    private IUser user;

@Override
    public DemandeConge ajouterdemandeConge(DemandeConge c) {
        return demandeConge.save(c);
    }
    @Override
    public DemandeConge modifierdemandeConge(Long idConge, DemandeConge c) {
        DemandeConge d = demandeConge.findById(idConge).get();

        d.setDateDebut(c.getDateDebut());
        d.setDateFin(c.getDateFin());
        d.setType(c.getType());
        d.setDuree(c.getDuree());
        return demandeConge.save(c);
    }
    @Override
    public List<DemandeConge> AfficheDemandeConge() {
        List<DemandeConge> conges= (List<DemandeConge>) demandeConge.findAll();
        return conges;
    }
@Override
public void supprimerDemandeConge(Long idConge) {
    demandeConge.deleteById(idConge);
}




}

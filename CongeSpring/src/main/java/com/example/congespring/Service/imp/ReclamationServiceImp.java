package com.example.congespring.Service.imp;

import com.example.congespring.Entity.Reclamation;
import com.example.congespring.Repository.ReclamationRepository;
import com.example.congespring.Service.interfaces.ReclamationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        Reclamationrepository.findAll().forEach(reclamation1->r.add(reclamation1));
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
    public Reclamation updateReclamation(Reclamation r) {
        return Reclamationrepository.save(r);
    }

    @Override
    public Reclamation retrieveReclamationById(Long id) {
        return Reclamationrepository.findById(id).get();
    }
}

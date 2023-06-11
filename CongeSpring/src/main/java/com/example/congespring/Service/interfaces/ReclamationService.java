package com.example.congespring.Service.interfaces;

import com.example.congespring.Entity.Reclamation;

import java.util.List;
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
@Service
public interface ReclamationService {

    List<Reclamation> retrieveAllReclamations();
    Reclamation addReclamation(Reclamation r);
    Reclamation updateReclamation(Reclamation r);
    Reclamation retrieveReclamationById(Long id);
}

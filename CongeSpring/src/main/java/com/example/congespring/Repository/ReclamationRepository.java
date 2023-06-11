package com.example.congespring.Repository;

import com.example.congespring.Entity.Reclamation;
import com.example.congespring.Entity.categorieReclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findByCategorieReclmation(categorieReclamation CategorieReclamation);


}

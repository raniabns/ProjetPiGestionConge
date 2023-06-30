package com.example.congespring.Repository;
import com.example.congespring.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    List<Reclamation> findByDateReclamationBefore(LocalDate date);

}

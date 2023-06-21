package com.example.congespring.Repository;

import com.example.congespring.Entity.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDemandeConge extends JpaRepository<DemandeConge, Long> {
long findByUserIdUser (Long idCUser);

}

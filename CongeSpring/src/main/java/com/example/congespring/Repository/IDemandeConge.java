package com.example.congespring.Repository;

import com.example.congespring.Entity.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemandeConge extends JpaRepository<DemandeConge, Long> {

}

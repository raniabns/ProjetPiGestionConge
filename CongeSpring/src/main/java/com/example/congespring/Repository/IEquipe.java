package com.example.congespring.Repository;

import com.example.congespring.Entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipe extends JpaRepository<Equipe,Long> {
}

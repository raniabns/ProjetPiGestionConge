package com.example.congespring.Repository;


import com.example.congespring.Entity.DemandeConge;
import com.example.congespring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUser extends JpaRepository<User, Long> {
 List<DemandeConge> findByEquipeIdEquipe(Long idEquipe);

}



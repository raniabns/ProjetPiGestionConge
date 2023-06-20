package com.example.congespring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String nom;
    String prenom;
    String mail;
    String motPasse;
    int soldeCongeInitial;
   int soldeCongeApris;
    int soldeconge;
    @Enumerated(EnumType.STRING)
     RoleType roletype;
    public User() {
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
@JsonIgnore
private Set<DemandeConge> conges;
    @ManyToOne
    private Equipe equipe;


    public boolean estAuTravail() {
        TypeConge typeconge = null;

        // Exemple : Vérifier si l'employé a un statut "Travail" ou "Congé Maladie" dans son emploi du temps actuel
        return typeconge == TypeConge.Travail;
    }
}

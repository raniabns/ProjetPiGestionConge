package com.example.congespring.Entity;

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
    Long soldeconge;
    @Enumerated(EnumType.STRING)
     RoleType roletype;
    public User() {
    }

@OneToMany(cascade = CascadeType.ALL, mappedBy="user")

private Set<DemandeConge> conges;
    @ManyToOne
    private Equipe equipe;


}

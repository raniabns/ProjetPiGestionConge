package com.example.congespring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Equipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  Long idEquipe;
  String nom;

    public Equipe() {
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy="equipe")

    private Set <User> users;

}

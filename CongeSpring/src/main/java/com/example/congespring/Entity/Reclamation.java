package com.example.congespring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idReclamation;
     String description;

    public Reclamation() {
    }
    @OneToOne(mappedBy="reclamation")
    private DemandeConge demandeConge;
}

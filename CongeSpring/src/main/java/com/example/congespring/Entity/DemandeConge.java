package com.example.congespring.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class DemandeConge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idConge;
	@Enumerated(EnumType.STRING)
	TypeConge type;
	@Temporal(TemporalType.DATE)
	Date dateDebut;
	@Temporal(TemporalType.DATE)
	Date dateFin;
	Long duree;
	Long nbreconge;
	String etatDemande;

	public DemandeConge() {

	}

	@ManyToOne
	private User user;
	@OneToOne
	private Reclamation reclamation;

	public boolean estAuTravail() {
		// Liste des types de congés qui indiquent que l'employé n'est pas au travail
		TypeConge[] typesAbsence = {
				TypeConge.conge_maladie,
				TypeConge.conge_sanssolde,
				TypeConge.conge_paye,
				TypeConge.conge_maladie,
				TypeConge.conge_ordinaire,
				TypeConge.conge_maternite,
				TypeConge.conge_annuel
				// Ajoutez d'autres types de congés d'absence ici si nécessaire

		};

		// Vérifier si le type de congé fait partie des types d'absence
		for (TypeConge absence : typesAbsence) {
			if (type == absence) {
				return false;
			}
		}

		return true;







}}

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
	 Date dateFin ;
     Long duree ;
	 Long nbreconge;
   public DemandeConge(){

   }
	@ManyToOne
	private User user;
	@OneToOne
	private  Reclamation reclamation;

	
	
}

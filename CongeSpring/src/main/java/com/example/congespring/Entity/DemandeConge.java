package com.example.congespring.Entity;

import java.util.Objects;

public class Conge {
	
	private  Long idConge;
	private TypeConge type;
	private String dateDebut;
	private String dateFin ;

	private Long soldeconge;
	public Long getIdConge() {
		return idConge;
	}
	public void setIdConge(Long idConge) {
		this.idConge = idConge;
	}
	public TypeConge getType() {
		return type;
	}
	public void setType(TypeConge type) {
		this.type = type;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public Long getSoldeconge() {
		return soldeconge;
	}
	public void setSoldeconge(Long soldeconge) {
		this.soldeconge = soldeconge;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idConge, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conge other = (Conge) obj;
		return Objects.equals(idConge, other.idConge) && type == other.type;
	}
	@Override
	public String toString() {
		return "Conge [idConge=" + idConge + ", type=" + type + ", soldeconge=" + soldeconge + "]";
	}
	public Conge(Long idConge, TypeConge type, String dateDebut, String dateFin, Long soldeconge) {
		super();
		this.idConge = idConge;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.soldeconge = soldeconge;
	}
	
	
	
}

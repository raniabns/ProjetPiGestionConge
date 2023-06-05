package com.example.congespring.Entity;

public class Reclamation {

    private int idReclamation;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int idReclamation, String description) {
        this.idReclamation = idReclamation;
        this.description = description;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "idReclamation=" + idReclamation +
                ", description='" + description + '\'' +
                '}';
    }
}

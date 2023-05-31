package com.example.congespring.Entity;

public class Equipe {

    private int idEquipe;
    private String nom;

    public Equipe() {
    }

    public Equipe(int idEquipe, String nom) {
        this.idEquipe = idEquipe;
        this.nom = nom;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Equipe{" + "idEquipe=" + idEquipe + ", nom='" + nom + '\'' + '}';
    }
}

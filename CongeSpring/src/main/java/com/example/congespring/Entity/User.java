package com.example.congespring.Entity;

public class User {

    private int idUser;
    private String nom;
    private String prenom;
    private String mail;
    private String motPasse;

    public User() {
    }

    public User(int idUser, String nom, String prenom, String mail, String motPasse) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motPasse = motPasse;
    }

    public int getIdEmploye() {
        return idUser;
    }

    public void setIdEmploye(int idEmploye) {
        this.idUser = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmploye=" + idUser +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", motPasse='" + motPasse + '\'' +
                '}';
    }
}

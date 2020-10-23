package com.concours.entity.lists;

import java.sql.Date;

public class planteurList {
    String matricule, nom, prenom, lieu, superficie, culture, tonnage;
    Date daten;

    public planteurList (){}
    public planteurList(String matricule, String nom, String prenom, Date daten, String lieu, String superficie, String culture, String tonnage) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.daten = daten;
        this.lieu = lieu;
        this.superficie = superficie;
        this.culture = culture;
        this.tonnage = tonnage;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Date getDaten() {
        return daten;
    }

    public void setDaten(Date daten) {
        this.daten = daten;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }
}

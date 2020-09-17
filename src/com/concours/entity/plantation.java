package com.concours.entity;

public class plantation {
    String id_plantation;
    String localisation;
    String surperficie;
    String certificat_prop;
    String photo_plantation;
    String matricule;
    String id_culture;
    String id_methode;

    public plantation(String id_plantation, String localisation, String surperficie, String certificat_prop, String photo_plantation, String matricule, String id_culture, String id_methode) {
        this.id_plantation = id_plantation;
        this.localisation = localisation;
        this.surperficie = surperficie;
        this.certificat_prop = certificat_prop;
        this.photo_plantation = photo_plantation;
        this.matricule = matricule;
        this.id_culture = id_culture;
        this.id_methode = id_methode;
    }

    public String getId_plantation() {
        return id_plantation;
    }

    public void setId_plantation(String id_plantation) {
        this.id_plantation = id_plantation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getSurperficie() {
        return surperficie;
    }

    public void setSurperficie(String surperficie) {
        this.surperficie = surperficie;
    }

    public String getCertificat_prop() {
        return certificat_prop;
    }

    public void setCertificat_prop(String certificat_prop) {
        this.certificat_prop = certificat_prop;
    }

    public String getPhoto_plantation() {
        return photo_plantation;
    }

    public void setPhoto_plantation(String photo_plantation) {
        this.photo_plantation = photo_plantation;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getId_culture() {
        return id_culture;
    }

    public void setId_culture(String id_culture) {
        this.id_culture = id_culture;
    }

    public String getId_methode() {
        return id_methode;
    }

    public void setId_methode(String id_methode) {
        this.id_methode = id_methode;
    }
}

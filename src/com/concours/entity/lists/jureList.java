package com.concours.entity.lists;

import java.util.Date;

public class jureList {

    String id_jure, nomj, prenomj,fonction,experience,participation, concours;
    Date daten;

    public jureList() { }

    public String getId_jure() {
        return id_jure;
    }

    public void setId_jure(String id_jure) {
        this.id_jure = id_jure;
    }

    public String getNomj() {
        return nomj;
    }

    public void setNomj(String nomj) {
        this.nomj = nomj;
    }

    public String getPrenomj() {
        return prenomj;
    }

    public void setPrenomj(String prenomj) {
        this.prenomj = prenomj;
    }

    public Date getDaten() {
        return daten;
    }

    public void setDaten(Date daten) {
        this.daten = daten;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getParticipation() {
        return participation;
    }

    public void setParticipation(String participation) {
        this.participation = participation;
    }

    public String getConcours() {
        return concours;
    }

    public void setConcours(String concours) {
        this.concours = concours;
    }
}

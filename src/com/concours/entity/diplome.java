package com.concours.entity;

public class diplome {
    String id_diplome;
    String libelle_diplome;
    String num_diplome;
    String matricule;

    public diplome(String id_diplome, String libelle_diplome, String num_diplome, String matricule) {
        this.id_diplome = id_diplome;
        this.libelle_diplome = libelle_diplome;
        this.num_diplome = num_diplome;
        this.matricule = matricule;
    }

    public String getId_diplome() {
        return id_diplome;
    }

    public void setId_diplome(String id_diplome) {
        this.id_diplome = id_diplome;
    }

    public String getLibelle_diplome() {
        return libelle_diplome;
    }

    public void setLibelle_diplome(String libelle_diplome) {
        this.libelle_diplome = libelle_diplome;
    }

    public String getNum_diplome() {
        return num_diplome;
    }

    public void setNum_diplome(String num_diplome) {
        this.num_diplome = num_diplome;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}

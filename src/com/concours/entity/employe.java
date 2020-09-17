package com.concours.entity;

public class employe {
    String id_emp;
    String nb_emp;
    String nb_fem;
    String salaire_moy;
    String age_mini;
    String certificat_decl;
    String matricule;
    String methode_culture;

    public employe(String id_emp, String nb_emp, String nb_fem, String salaire_moy, String age_mini, String certificat_decl, String matricule, String methode_culture) {
        this.id_emp = id_emp;
        this.nb_emp = nb_emp;
        this.nb_fem = nb_fem;
        this.salaire_moy = salaire_moy;
        this.age_mini = age_mini;
        this.certificat_decl = certificat_decl;
        this.matricule = matricule;
        this.methode_culture = methode_culture;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }

    public String getNb_emp() {
        return nb_emp;
    }

    public void setNb_emp(String nb_emp) {
        this.nb_emp = nb_emp;
    }

    public String getNb_fem() {
        return nb_fem;
    }

    public void setNb_fem(String nb_fem) {
        this.nb_fem = nb_fem;
    }

    public String getSalaire_moy() {
        return salaire_moy;
    }

    public void setSalaire_moy(String salaire_moy) {
        this.salaire_moy = salaire_moy;
    }

    public String getAge_mini() {
        return age_mini;
    }

    public void setAge_mini(String age_mini) {
        this.age_mini = age_mini;
    }

    public String getCertificat_decl() {
        return certificat_decl;
    }

    public void setCertificat_decl(String certificat_decl) {
        this.certificat_decl = certificat_decl;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMethode_culture() {
        return methode_culture;
    }

    public void setMethode_culture(String methode_culture) {
        this.methode_culture = methode_culture;
    }
}

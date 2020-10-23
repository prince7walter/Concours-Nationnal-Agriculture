package com.concours.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Planteur {

      private String matricule;
      private String nom;
      private String prenom;
      private String email;
      private String dateN;
      private String lieuN;
      private String nation;
      private String contact;
      private String img;
      private String numDipl;
      private String numPc;
      private String imgPc;
      private String niveau;
      private int typeDipl;
      private int typePiec;
      private String diplome;
      private String localisation;
      private String superficie;
      private int culture;
      private int methode;
      private String certificat;
      private String employe;
      private String employeFem;
      private String tonnage;
      private String salaire;
      private String age;
      private String emplCert;

    public Planteur() {
    }

    public Planteur(String matricule, String nom, String prenom, String email, String dateN, String lieuN, String nation, String contact, String img, String numDipl, String numPc, String imgPc, String niveau, int typeDipl, int typePiec, String diplome, String localisation, String superficie, int culture, int methode, String certificat, String employe, String employeFem, String tonnage, String salaire, String age, String emplCert) {
        this.matricule = matricule; this.nom = nom; this.prenom = prenom; this.email = email; this.dateN = dateN; this.lieuN = lieuN; this.nation = nation;
        this.contact = contact; this.img=img; this.numDipl = numDipl; this.numPc = numPc; this.imgPc = imgPc; this.niveau = niveau; this.typeDipl = typeDipl;
        this.typePiec = typePiec; this.diplome = diplome; this.localisation = localisation; this.superficie = superficie; this.culture = culture;
        this.methode = methode; this.certificat = certificat; this.employe = employe; this.employeFem = employeFem; this.tonnage = tonnage;
        this.salaire = salaire; this.age = age; this.emplCert = emplCert;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateN() {
        return dateN;
    }

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    public String getLieuN() {
        return lieuN;
    }

    public void setLieuN(String lieuN) {
        this.lieuN = lieuN;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNumDipl() {
        return numDipl;
    }

    public void setNumDipl(String numDipl) {
        this.numDipl = numDipl;
    }

    public String getNumPc() {
        return numPc;
    }

    public void setNumPc(String numPc) {
        this.numPc = numPc;
    }

    public String getImgPc() {
        return imgPc;
    }

    public void setImgPc(String imgPc) {
        this.imgPc = imgPc;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getTypeDipl() {
        return typeDipl;
    }

    public void setTypeDipl(int typeDipl) {
        this.typeDipl = typeDipl;
    }

    public int getTypePiec() {
        return typePiec;
    }

    public void setTypePiec(int typePiec) {
        this.typePiec = typePiec;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public int getCulture() {
        return culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public int getMethode() {
        return methode;
    }

    public void setMethode(int methode) {
        this.methode = methode;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    public String getEmploye() {
        return employe;
    }

    public void setEmploye(String employe) {
        this.employe = employe;
    }

    public String getEmployeFem() {
        return employeFem;
    }

    public void setEmployeFem(String employeFem) {
        this.employeFem = employeFem;
    }

    public String gettonnage() {
        return tonnage;
    }

    public void settonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmplCert() {
        return emplCert;
    }

    public void setEmplCert(String emplCert) {
        this.emplCert = emplCert;
    }

    @Override
    public String toString() {
        return "Planteur{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dateN='" + dateN + '\'' +
                ", lieuN='" + lieuN + '\'' +
                ", nation='" + nation + '\'' +
                ", contact='" + contact + '\'' +
                ", img='" + img + '\'' +
                ", numDipl='" + numDipl + '\'' +
                ", numPc='" + numPc + '\'' +
                ", imgPc='" + imgPc + '\'' +
                ", niveau='" + niveau + '\'' +
                ", typeDipl=" + typeDipl +
                ", typePiec=" + typePiec +
                ", diplome='" + diplome + '\'' +
                ", localisation='" + localisation + '\'' +
                ", superficie='" + superficie + '\'' +
                ", culture=" + culture +
                ", methode=" + methode +
                ", certificat='" + certificat + '\'' +
                ", employe='" + employe + '\'' +
                ", employeFem='" + employeFem + '\'' +
                ", tonnage='" + tonnage + '\'' +
                ", salaire='" + salaire + '\'' +
                ", age='" + age + '\'' +
                ", emplCert='" + emplCert + '\'' +
                '}';
    }
}

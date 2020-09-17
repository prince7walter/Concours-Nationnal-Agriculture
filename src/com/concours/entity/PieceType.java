package com.concours.entity;

public class PieceType {
    String libelleP;

    public PieceType(){}
    public PieceType(String libelle) {
        this.libelleP = libelle;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelle) {
        this.libelleP = libelle;
    }
}

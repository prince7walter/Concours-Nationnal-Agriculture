package com.concours.entity;

import com.concours.database.DB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanteurManager {
    DB db =new DB();

    public int add(Planteur planteur) {
        String sql1 = "INSERT INTO CONCOURS.PLANTEUR VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO CONCOURS.plantation VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sql3 = "INSERT INTO CONCOURS.EMPLOYE VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql4 = "INSERT INTO CONCOURS.DIPLOME VALUES (?, ?, ?, ?)";
        String sql5 = "INSERT INTO CONCOURS.PIECE VALUES (?, ?, ?, ?, ?)";

        int ok = 0 ;
        try {
            db.initPrepar(sql1);
            db.getPstm().setString(1, "PLTR"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getNom());
            db.getPstm().setString(3, planteur.getPrenom());
            db.getPstm().setString(4, planteur.getEmail());
            db.getPstm().setString(5, planteur.getDateN());
            db.getPstm().setString(6, planteur.getLieuN());
            db.getPstm().setString(7, planteur.getNation());
            db.getPstm().setString(8, planteur.getContact());
            db.getPstm().setString(9, planteur.getNiveau());
            db.getPstm().setString(10, planteur.getImg());

            ok = db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        int fx =0;
        try {
            db.initPrepar(sql2);
            db.getPstm().setString(1, "PTN"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getLocalisation());
            db.getPstm().setString(3, planteur.getSuperficie());
            db.getPstm().setString(4, planteur.getCertificat());
            db.getPstm().setString(5, planteur.gettonnage());
            db.getPstm().setString(6, "PLTR"+planteur.getDateN());
            db.getPstm().setInt(7, planteur.getCulture());
            db.getPstm().setInt(8, planteur.getMethode());

            ok= db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            db.initPrepar(sql3);
            db.getPstm().setString(1, "EMP"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getEmploye());
            db.getPstm().setString(3, planteur.getEmployeFem());
            db.getPstm().setString(4, planteur.getSalaire());
            db.getPstm().setString(5, planteur.getAge());
            db.getPstm().setString(6, planteur.getEmplCert());
            db.getPstm().setString(7, "PLTR"+planteur.getDateN());

            ok=db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            db.initPrepar(sql4);
            db.getPstm().setString(1, "DPL"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getDiplome());
            db.getPstm().setString(3, planteur.getNumDipl());
            db.getPstm().setString(4, "PLTR"+planteur.getDateN());
            db.getPstm().setInt(5,planteur.getTypeDipl());

            ok=db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            db.initPrepar(sql5);
            db.getPstm().setString(1, "PIC"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getImgPc());
            db.getPstm().setString(3, planteur.getNumPc());
            db.getPstm().setString(4, "PLTR"+planteur.getDateN());
            db.getPstm().setInt(5, planteur.getTypePiec());

            ok=db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return ok;
    }

    public List<Planteur> get()
    {
        String sql ="SELECT * FROM planteur";
        List<Planteur> planteurList = new ArrayList<Planteur>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while (rs.next()){
                Planteur pl = new Planteur();
                pl.setMatricule(rs.getNString("matricule"));
                pl.setNom(rs.getNString("nom"));
                pl.setPrenom(rs.getNString("prenom"));
                pl.setDateN(rs.getNString("daten"));
                pl.setLocalisation(rs.getNString("nom"));
                pl.setSuperficie(rs.getNString("prenom"));
                pl.setNumDipl("dd");
                pl.setCertificat("dd");
                pl.setDiplome("dd");
                pl.setNation("dd");
                pl.setNiveau("dd");

                planteurList.add(pl);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return planteurList;
    }
}

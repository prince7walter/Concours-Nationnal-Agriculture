package com.concours.entity;

import com.concours.database.DB;

public class PlanteurManager {
    DB db =new DB();

    public int add(Planteur planteur) {
        String sql1 = "INSERT INTO CONCOURS.PLANTEUR VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO CONCOURS.PLANTATION VALUES (?, ?, ?, ?, ?, ?, ?)";
      //  String sql3 = "INSERT INTO CONCOURS.EMPLOYE VALUES (?, ?, ?, ?, ?, ?, ?)";
      //  String sql4 = "INSERT INTO CONCOURS.FICHIER VALUES (?, ?, ?, ?)";
        int ok = 0 ;
        try {
            db.initPrepar(sql1);
            db.getPstm().setString(1, planteur.getMatricule());
            db.getPstm().setString(2, planteur.getNom());
            db.getPstm().setString(3, planteur.getPrenom());
            db.getPstm().setString(4, planteur.getEmail());
            db.getPstm().setString(5, planteur.getDateN());
            db.getPstm().setString(6, planteur.getLieuN());
            db.getPstm().setString(7, planteur.getNation());
            db.getPstm().setString(8, planteur.getContact());
            db.getPstm().setString(9, planteur.getNiveau());
            db.getPstm().setString(10, planteur.getTypPc());
            db.getPstm().setString(11, planteur.getNumPc());

            ok = db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        int fx =0;
        try {
            db.initPrepar(sql2);
            db.getPstm().setString(1, planteur.getDateN());
            db.getPstm().setString(2, planteur.getMatricule());
            db.getPstm().setString(3, planteur.getCulture());
            db.getPstm().setString(4, planteur.getLocalisation());
            db.getPstm().setString(5, planteur.getSuperficie());
            db.getPstm().setString(6, planteur.getMethode());
            db.getPstm().setString(7, planteur.getAnnee());

            ok= db.executeMaj();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        /*try {
            db.initPrepar(sql3);
            db.getPstm().setString(1, "EMP"+planteur.getDateN());
            db.getPstm().setString(2, planteur.getMatricule());
            db.getPstm().setString(3, planteur.getEmploye());
            db.getPstm().setString(4, planteur.getEmployeFem());
            db.getPstm().setString(5, planteur.getEmployeDec());
            db.getPstm().setString(6, planteur.getSalaire());
            db.getPstm().setString(7, planteur.getAge());
        } catch (Exception ex){
            ex.printStackTrace();
        }
*/
        return ok;


    }
}

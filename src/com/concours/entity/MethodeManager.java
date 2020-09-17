package com.concours.entity;

import com.concours.database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MethodeManager {
    private DB db = new DB();

    public List<Methode> get(){

        String sql="Select libelle_methode From methode_culture";
        List<Methode> methodes = new ArrayList<>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while (rs.next()){
                Methode md = new Methode();
                md.setLibelleM(rs.getString(1));

                methodes.add(md);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //System.out.println(diplomes);
        return methodes;

    }
}

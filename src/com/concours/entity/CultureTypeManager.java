package com.concours.entity;

import com.concours.database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CultureTypeManager {

    private DB db = new DB();

    public List<CultureType> get(){

        String sql="Select libelle_type_culture From type_culture";
        List<CultureType> cultureTypes = new ArrayList<>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while (rs.next()){
                CultureType cl = new CultureType();
                cl.setLibelleC(rs.getNString(1));

                cultureTypes.add(cl);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //System.out.println(diplomes);
        return cultureTypes;

    }
}

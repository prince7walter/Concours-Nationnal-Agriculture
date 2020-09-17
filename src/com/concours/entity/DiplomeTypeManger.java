package com.concours.entity;


import com.concours.database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiplomeTypeManger {

    private DB db = new DB();


    public List<DiplomeType> get(){

        String sql="Select libelle_diplome From type_diplome";
        List<DiplomeType> diplomeTypes = new ArrayList<>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while (rs.next()){
                DiplomeType dp = new DiplomeType();
                dp.setLibelleD(rs.getString(1));

                diplomeTypes.add(dp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //System.out.println(diplomes);
        return diplomeTypes;

    }
}

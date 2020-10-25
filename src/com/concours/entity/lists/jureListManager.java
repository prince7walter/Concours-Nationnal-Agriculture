package com.concours.entity.lists;

import com.concours.database.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jureListManager {

    DB db =new DB();
    ResultSet rs;
    jureList j;
    //F==> CAFE
    //O==> CACAO

    public ObservableList<jureList> getAll(){
        ObservableList<jureList> list = FXCollections.observableArrayList();
        String sql = "select * from alljure";

        try
        {
            db.initPrepar(sql);
            rs = db.executeSelect();

            while (rs.next()){
                j=new jureList();
                j.setId_jure(rs.getString(1));
                j.setNomj(rs.getString(2));
                j.setPrenomj(rs.getString(3));
                j.setDaten(rs.getString(4));
                j.setFonction(rs.getString(5));
                j.setParticipation(rs.getString(6));
                j.setExperience(rs.getString(7));
                j.setConcours(rs.getString(8));

                list.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ObservableList<jureList> getF () {
        String sql = "select * from jurefview";
        ObservableList<jureList> list = FXCollections.observableArrayList();
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();

            while (rs.next()) {
                j = new jureList();
                j.setId_jure(rs.getString(1));
                j.setNomj(rs.getString(2));
                j.setPrenomj(rs.getString(3));
                list.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ObservableList<jureList> getO () {
        String sql = "select * from jureoview";
        ObservableList<jureList> list = FXCollections.observableArrayList();
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();

            while (rs.next()) {
                j = new jureList();
                j.setId_jure(rs.getString(1));
                j.setNomj(rs.getString(2));
                j.setPrenomj(rs.getString(3));
                list.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
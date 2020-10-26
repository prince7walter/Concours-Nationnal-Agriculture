package com.concours.entity.lists;

import com.concours.database.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class visiteManager {
    private DB db = new DB();
    private Connection cnx;
    private CallableStatement cs;
    private ResultSet rs;
    private visiteList v;

    public void addO (String n,String d,String h,String j){
        String sql ="call addvisite(?,?,?,?)";
        try {
            db.getConnection();
            cs= cnx.prepareCall(sql);
            cs.setString(1,n);
            cs.setString(2,n);
            cs.setString(3,h);
            cs.setString(4,j);
            cs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ObservableList<visiteList> getf ()
    {
        String sql = "select * from visitef";

        ObservableList<visiteList> list = FXCollections.observableArrayList();
        try
        {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();

            while (rs.next())
            {
                v = new visiteList();
                v.setCandidat(rs.getString(1));
                v.setDate(rs.getString(2));
                v.setHeure(rs.getString(3));
                v.setJuge(rs.getString(4));
                v.setEtat(rs.getString(5));

                list.add(v);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ObservableList<visiteList> geto ()
    {
        String sql = "select * from visiteo";

        ObservableList<visiteList> list = FXCollections.observableArrayList();
        try
        {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();

            while (rs.next())
            {
                v = new visiteList();
                v.setCandidat(rs.getString(1));
                v.setDate(rs.getString(2));
                v.setHeure(rs.getString(3));
                v.setJuge(rs.getString(4));
                v.setEtat(rs.getString(5));

                list.add(v);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

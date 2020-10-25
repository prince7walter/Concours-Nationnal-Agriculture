package com.concours.entity.lists;

import com.concours.database.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class candidatListManger {
    DB db =new DB();

    public ObservableList<candidatList> getF () {
        String sql = "select  * from candidatfview";
        ObservableList<candidatList> list = FXCollections.observableArrayList();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();

            while (rs.next()) {
                candidatList j = new candidatList();
                j.setMatricule(rs.getString(1));
                j.setNom(rs.getString(2));
                j.setPrenom(rs.getString(3));
                list.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public ObservableList<candidatList> getO () {
        String sql = "select * from candidatoview";
        ObservableList<candidatList> list = FXCollections.observableArrayList();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();

            while (rs.next()) {
                candidatList j = new candidatList();
                j.setMatricule(rs.getString(1));
                j.setNom(rs.getString(2));
                j.setPrenom(rs.getString(3));

                list.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

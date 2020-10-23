package com.concours.entity.lists;

import com.concours.database.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class planteurListManager {
    DB db =new DB();

    public ObservableList<planteurList> get ()
    {
        String sql ="select distinct * from planteurlist";
      ObservableList<planteurList> list = FXCollections.observableArrayList();
      try
      {
          db.initPrepar(sql);
          ResultSet rs = db.executeSelect();

          while (rs.next())
          {
              planteurList p =new planteurList();
              p.setMatricule(rs.getString(1));
              p.setNom(rs.getString(2));
              p.setPrenom(rs.getString(3));
              p.setDaten(rs.getDate(4));
              p.setLieu(rs.getString(5));
              p.setSuperficie(rs.getString(6));
              p.setCulture(rs.getString(7));

              list.add(p);
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
        return list;
    }
}

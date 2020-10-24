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
        String sql ="select distinct * from planteurview";
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
              p.setEmail(rs.getString(4));
              p.setDaten(rs.getDate(5));
              p.setLieun(rs.getString(6));
              p.setNationnalite(rs.getString(7));
              p.setContact(rs.getString(8));
              p.setNiveau(rs.getString(9));
              p.setPhoto(rs.getString(10));
              p.setLocalisation(rs.getString(11));
              p.setSuperficie(rs.getString(12));
              p.setTonnage(rs.getString(13));
              p.setCertificat_prop(rs.getString(14));
              p.setNb_emp(rs.getString(15));
              p.setNb_fem(rs.getString(16));
              p.setSalaire_moy(rs.getString(17));
              p.setAge_mini(rs.getString(18));
              p.setCertificat_decl(rs.getString(19));
              p.setDiplome(rs.getString(20));
              p.setNum_diplome(rs.getString(21));
              p.setMethode(rs.getString(22));
              p.setLibelle_piece(rs.getString(23));
              p.setNum_piece(rs.getString(24));
              p.setCulture(rs.getString(25));
              p.setPiece(rs.getString(26));
              p.setNom_dipl(rs.getString(27));
              list.add(p);
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
        return list;
    }


}

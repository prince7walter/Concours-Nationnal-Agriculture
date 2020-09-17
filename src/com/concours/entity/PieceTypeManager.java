package com.concours.entity;

import com.concours.database.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceTypeManager {

    private DB db = new DB();

    public List<PieceType> get() {
        String sql = "Select libelle_type_piece From type_piece";
        List<PieceType> pieces = new ArrayList<>();
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                PieceType pc = new PieceType();
                pc.setLibelleP(rs.getString(1));

                pieces.add(pc);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return pieces;
    }
}

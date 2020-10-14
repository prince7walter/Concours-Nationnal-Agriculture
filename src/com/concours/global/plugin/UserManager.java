
package com.concours.global.plugin;

import com.concours.database.DB;
import com.concours.global.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class UserManager {

    private DB db =new DB();

    public User get(String login, String pass) {
        User user = null;
        String sql = "SELECT * FROM utilisateur WHERE login=? AND mdp=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, login);
            db.getPstm().setString(2, pass);

            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString(1));
                user.setPassword(rs.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public User getp(String login) {
        User user = null;
        String sql = "SELECT * FROM utilisateur WHERE login=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, login);

            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void save(User user) {
        String sql = "INSERT INTO CONCOURS.UTILISATEUR VALUES (NULL, ?,?,?,?,?)";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, user.getUserName());
            db.getPstm().setString(2, user.getFullName());
            db.getPstm().setString(3, "-");
            db.getPstm().setString(4, user.getEmail());
            db.getPstm().setString(5, user.getPassword());

            ok = db.executeMaj();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

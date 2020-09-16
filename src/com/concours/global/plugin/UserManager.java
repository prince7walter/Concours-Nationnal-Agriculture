
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

    public static void save(User user) {
        try {
            File file = new File("user/" + user.getUserName() + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);

            FileOutputStream outputStream = new FileOutputStream(file);

            properties.setProperty("fullName", user.getFullName());
            properties.setProperty("email", user.getEmail());
            properties.setProperty("password", user.getPassword());
            properties.store(outputStream, "Update Section");
            properties.clear();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

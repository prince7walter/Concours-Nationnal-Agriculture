/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

    public User get(String pseudo, String pass) {
        User user = null;
        String sql = "SELECT * FROM users WHERE pseudo=? AND pass=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, pseudo);
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

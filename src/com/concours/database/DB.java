package com.concours.database;


import java.sql.*;

public class DB {
    //pour la connexion
    private Connection cnx;
    //pour les resultats de requetes de type SELECT
    private ResultSet rs;
    //pour les requetes preparees
    private PreparedStatement pstm;
    //pour les resultats de requetes de type mise à jour
    private int ok;



    public void getConnection (){
        String url = "jdbc:oracle:thin:@localhost:1522:orcle";
        String user ="concours";
        String password = "concours";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cnx = DriverManager.getConnection(url,user,password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initPrepar (String sql){
        try {
            getConnection();

            pstm = cnx.prepareStatement(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect (){
        try {
            rs= pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeMaj (){
        try {
            ok = pstm.executeUpdate();
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }

    public void closeConnection (){
        try {
            if (cnx != null)
                cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm () throws SQLException {
        return pstm;
    }
}

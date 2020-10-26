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

    private CallableStatement cs;



    public void getConnection (){
        String url = "jdbc:oracle:oci:@localhost:1522:orcle";
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


    public void callProcd (String l,String n,String e,String p){
        String sql ="call addusers(?,?,?,?)";
        try {
            getConnection();
            cs= cnx.prepareCall(sql);
            cs.setString(1,l);
            cs.setString(2,n);
            cs.setString(3,e);
            cs.setString(4,p);
            cs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void conforme(String mat) throws SQLException {
        String sql ="call avisc1(?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,mat);
            cs.executeUpdate();
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void nonconforme(String mat) throws SQLException {
        String sql ="call avisc2(?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,mat);
            cs.executeUpdate();
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void avis(String mat) throws SQLException {
        String sql ="call avisj1(?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,mat);
            cs.executeUpdate();
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void nonavis(String mat) throws SQLException {
        String sql ="call avisj2(?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,mat);
            cs.executeUpdate();
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addVisitef (String n,String d, String h, String j)
    {
        String sql ="call addviste(?,?,?,?,?,?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,"VSTF");
            cs.setString(2,n);
            cs.setString(3,d);
            cs.setString(4,h);
            cs.setString(5,j);
            cs.setString(6,"1");
            cs.setString(7,"5");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void addVisiteo (String n,String d, String h, String j)
    {
        String sql ="call addviste(?,?,?,?,?)";
        try
        {
            getConnection();
            cs=cnx.prepareCall(sql);
            cs.setString(1,"VSTO");
            cs.setString(2,n);
            cs.setString(3,d);
            cs.setString(4,h);
            cs.setString(5,j);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

package com.concours.module.visite;

import com.concours.database.DB;
import com.concours.entity.lists.planteurList;
import com.concours.entity.lists.visiteList;
import com.concours.entity.lists.visiteManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class visite implements Initializable {

    @FXML private ComboBox<String> combo_candidat;
    @FXML private DatePicker dateViste;
    @FXML private ComboBox<String> combo_heure;
    @FXML private Button visiteSet;
    @FXML private TableView<visiteList> cafeView;
    @FXML private TableColumn<visite, String> candidatView;
    @FXML private TableColumn<visite, String> dateView;
    @FXML private TableColumn<visite, String> heureView;
    @FXML private TableColumn<visite, String> jugesView;
    @FXML private TableColumn<visite, String> etatView;
    @FXML private ComboBox<String> combo_juges;
    @FXML private Button visiteUp;
    @FXML private ComboBox<String> combo_candidat1;
    @FXML private DatePicker dateViste1;
    @FXML private ComboBox<String> combo_heure1;
    @FXML private Button visiteSet1;
    @FXML private TableView<visiteList> cacaoView;
    @FXML private TableColumn<visite, String> candidatView1;
    @FXML private TableColumn<visite, String> dateView1;
    @FXML private TableColumn<visite, String> heureView1;
    @FXML private TableColumn<visite, String> jugesView1;
    @FXML private TableColumn<visite, String> etatView1;
    @FXML private ComboBox<String> combo_juges1;
    @FXML private Button visiteUp1;

    //BD
    private DB db = new DB();
    private Connection cnx;
    private CallableStatement cs;
    private ResultSet rs;

    //Entitee
    private visiteList visiteList ;
    private visiteManager visteLM = new visiteManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    getItems();
    getView();
    setView();
    }

    private void getItems()
    {
        //Candidat
        String sqlf="Select * from planteurf";
        db.getConnection();

        try {
            db.initPrepar(sqlf);
            rs=db.executeSelect();
            while (rs.next()){
                combo_candidat.getItems().add(rs.getString(1)+" "+rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlf1="Select * from planteuro";
        db.getConnection();

        try {
            db.initPrepar(sqlf1);
            rs=db.executeSelect();
            while (rs.next()){
                combo_candidat1.getItems().add(rs.getString(1)+" "+rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Heure
        combo_heure.getItems().add("8H - 9H");
        combo_heure.getItems().add("9H - 10H");
        combo_heure.getItems().add("10H - 11H");
        combo_heure.getItems().add("11H - 12H");

        combo_heure1.getItems().add("8H - 9H");
        combo_heure1.getItems().add("9H - 10H");
        combo_heure1.getItems().add("10H - 11H");
        combo_heure1.getItems().add("11H - 12H");

        //juge
        String sqlj="Select * from jugef";
        db.getConnection();

        try {
            db.initPrepar(sqlj);
            rs=db.executeSelect();
            while (rs.next()){
                combo_juges.getItems().add(rs.getString(1)+" "+rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sqlj1="Select * from jugef";
        db.getConnection();

        try {
            db.initPrepar(sqlj1);
            rs=db.executeSelect();
            while (rs.next()){
                combo_juges1.getItems().add(rs.getString(1)+" "+rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void getView()
    {
        //CAFE
        ObservableList<visiteList> visites = FXCollections.observableArrayList();
        List<visiteList> vis =visteLM.getf();
        for (visiteList v : vis){
            visites.add(v);
        }
        cafeView.setItems(visites);

        //CACAO
        ObservableList<visiteList> visiteso = FXCollections.observableArrayList();
        List<visiteList> viso =visteLM.getf();
        for (visiteList v : viso){
            visiteso.add(v);
        }
        cacaoView.setItems(visiteso);
    }

    public void setView()
    {
        //cafe
        dateView.setCellValueFactory(new PropertyValueFactory<>("date"));
        candidatView.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        heureView.setCellValueFactory(new PropertyValueFactory<>("heure"));
        jugesView.setCellValueFactory(new PropertyValueFactory<>("juge"));
        etatView.setCellValueFactory(new PropertyValueFactory<>("etat"));

        //caco
        dateView1.setCellValueFactory(new PropertyValueFactory<>("date"));
        candidatView1.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        heureView1.setCellValueFactory(new PropertyValueFactory<>("heure"));
        jugesView1.setCellValueFactory(new PropertyValueFactory<>("juge"));
        etatView1.setCellValueFactory(new PropertyValueFactory<>("etat"));
    }

    public void enregistrer(ActionEvent event) {
    }

}

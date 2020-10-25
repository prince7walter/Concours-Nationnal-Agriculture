package com.concours.module.organisation;

import com.concours.entity.lists.candidatList;
import com.concours.entity.lists.candidatListManger;
import com.concours.entity.lists.jureList;
import com.concours.entity.lists.jureListManager;
import com.concours.entity.lists.planteurList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class organisation implements Initializable {

    //table view
    @FXML private TableView<jureList> jureView;
    @FXML private TableColumn<jureList, String> idJView;
    @FXML private TableColumn<jureList, String> nomJView;
    @FXML private TableColumn<jureList, String> prenomJView;
    @FXML private TableView<jureList> jureView1;
    @FXML private TableColumn<jureList, String> idJView1;
    @FXML private TableColumn<jureList, String> nomJView1;
    @FXML private TableColumn<jureList, String> prenomJView1;
    @FXML private TableView<candidatList> candidatView;
    @FXML private TableColumn<candidatList, String> matriculeCView;
    @FXML private TableColumn<candidatList, String> nomCView;
    @FXML private TableColumn<candidatList, String> prenomCView;
    @FXML private TableView<candidatList> candidatView1;
    @FXML private TableColumn<candidatList, String> matriculeCView1;
    @FXML private TableColumn<candidatList, String> nomCView1;
    @FXML private TableColumn<candidatList, String> prenomCView1;

    //Entités
    private jureList jureList;
    private jureListManager jureLM= new jureListManager();
    private candidatList candidatList;
    private candidatListManger candidatLM = new candidatListManger();

    public organisation() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        load();
        ViewAdd();

    }

    //Recuperer les valeurs
    public void load()
    {
        //lord juresF
        ObservableList<jureList> juresF = FXCollections.observableArrayList();
        List<jureList> jureListF = jureLM.getF();
        for (jureList j : jureListF){
            juresF.add(j);
        }
        jureView.setItems(juresF);

        //lord juresO
        ObservableList<jureList> juresO = FXCollections.observableArrayList();
        List<jureList> jureListO = jureLM.getO();
        for (jureList j : jureListO){
            juresO.add(j);
        }
        jureView1.setItems(juresO);

        //lord candidatF
        ObservableList<candidatList> candidatsF = FXCollections.observableArrayList();
        List<candidatList> candidatListF = candidatLM.getF();
        for (candidatList c : candidatListF){
            candidatsF.add(c);
        }
        candidatView.setItems(candidatsF);

        //lord candidatO
        ObservableList<candidatList> candidatsO = FXCollections.observableArrayList();
        List<candidatList> candidatListsO = candidatLM.getO();
        for (candidatList l : candidatListsO){
            candidatsO.add(l);
        }
        candidatView1.setItems(candidatsO);
    }
    
    //Affecter les valeurs aux table
    public void ViewAdd()
    {
        //add juresF
        idJView.setCellValueFactory(new PropertyValueFactory<>("id_jure"));
        nomJView.setCellValueFactory(new PropertyValueFactory<>("nomj"));
        prenomJView.setCellValueFactory(new PropertyValueFactory<>("prenomj"));

        //add juresO
        idJView1.setCellValueFactory(new PropertyValueFactory<>("id_jure"));
        nomJView1.setCellValueFactory(new PropertyValueFactory<>("nomj"));
        prenomJView1.setCellValueFactory(new PropertyValueFactory<>("prenomj"));

        //add candidatF
        matriculeCView.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        nomCView.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCView.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        //add candidatO
        matriculeCView1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        nomCView1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCView1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    }
}

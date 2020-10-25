package com.concours.module.jures;

import com.concours.entity.lists.jureList;
import com.concours.entity.lists.jureListManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class jures implements Initializable {

    //table view
    @FXML private TableView<jureList> allJureView;
    @FXML private TableColumn<jureList, String> idView;
    @FXML private TableColumn<jureList, String> nomView;
    @FXML private TableColumn<jureList, String> prenomsView;
    @FXML private TableColumn<jureList, String> datenView;
    @FXML private TableColumn<jureList, String> fonctionView;
    @FXML private TableColumn<jureList, String> experienceView;
    @FXML private TableColumn<jureList, String> partView;
    @FXML private TableColumn<jureList, String> concoursView;
    @FXML private Button admisBtn;
    @FXML private Button rejeteBtn;

    //Entitée
    private jureList jureList;
    private jureListManager jureLM= new jureListManager() ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lord();
        viewAdd();
    }

    public void lord ()
    {
        ObservableList<jureList> Lists = FXCollections.observableArrayList();
        List<jureList> jureList = jureLM.getAll();
        for (jureList j : jureList)
        {
            Lists.add(j);
        }
        allJureView.setItems(Lists);
    }

    public void viewAdd()
    {
        idView.setCellValueFactory(new PropertyValueFactory<>("id_jure"));
        nomView.setCellValueFactory(new PropertyValueFactory<>("nomj"));
        prenomsView.setCellValueFactory(new PropertyValueFactory<>("prenomj"));
        datenView.setCellValueFactory(new PropertyValueFactory<>("daten"));
        fonctionView.setCellValueFactory(new PropertyValueFactory<>("fonction"));
        experienceView.setCellValueFactory(new PropertyValueFactory<>("experience"));
        partView.setCellValueFactory(new PropertyValueFactory<>("participation"));
        concoursView.setCellValueFactory(new PropertyValueFactory<>("concours"));
    }
}

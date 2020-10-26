package com.concours.module.jures;

import com.concours.database.DB;
import com.concours.entity.lists.jureList;
import com.concours.entity.lists.jureListManager;
import com.concours.tools.Notification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
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

    @FXML private Label hideId;
    @FXML private Label hideId1;
    @FXML private Label hideId11;

    //Entitée
    DB db = new DB();
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

    public void listClick(MouseEvent event) {
       jureList = allJureView.getSelectionModel().getSelectedItem();
       hideId.setText(jureList.getId_jure());
       hideId1.setText(jureList.getNomj());
       hideId11.setText(jureList.getPrenomj());
    }

    public void setAvis1 (ActionEvent event) throws SQLException {
        db.avis(hideId.getText());
        lord();
        viewAdd();
        Notification.NotifSucces("Super", "Vous avez accepté la candidature de "+hideId1.getText()+" "+hideId11.getText());

    }
    public void setAvis2 (ActionEvent event) throws SQLException {
        db.nonavis(hideId.getText());
        lord();
        viewAdd();
        Notification.NotifError("Super", "Vous avez réjété la candidature de "+hideId1.getText()+" "+hideId11.getText());

    }
}

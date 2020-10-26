package com.concours.module.dashbord;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menu implements Initializable {

    @FXML private VBox principale;
    @FXML private Label lbCand;
    @FXML private Label lbJury;
    @FXML private Label lbOrgan;
    @FXML private Label Result;

    private StackPane cand, jury, orgn, res;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void chargerCand()
    {
        try
        {
            Parent pCand = FXMLLoader.load(getClass().getResource("/com/concours/module/candidat/candidat.fxml"));
            cand = (StackPane) pCand;
            cand.setMaxWidth(Double.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void chargerJury()
    {
        try
        {
            Parent pCand = FXMLLoader.load(getClass().getResource("/com/concours/module/jures/jures.fxml"));
            jury = (StackPane) pCand;
            jury.setMaxWidth(Double.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void chargerOrgn()
    {
        try
        {
            Parent pOrg = FXMLLoader.load(getClass().getResource("/com/concours/module/organisation/organisation.fxml"));
            orgn = (StackPane) pOrg;
            orgn.setMaxWidth(Double.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void selectCandidat()
    {
        if (null == cand)
            chargerCand();
        principale.getChildren().clear();
        principale.getChildren().add(cand);
    }

    public void selectJury()
    {
        if (null == jury)
            chargerJury();
        principale.getChildren().clear();
        principale.getChildren().add(jury);
    }

    public void selectOrganise()
    {
        if (null == orgn)
            chargerOrgn();
        principale.getChildren().clear();
        principale.getChildren().add(orgn);
    }

}

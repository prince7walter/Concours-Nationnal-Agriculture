package com.concours.module.login;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.concours.database.DB;
import com.concours.global.User;
import com.concours.global.plugin.UserManager;
import com.concours.global.plugin.ViewManager;
import com.concours.tools.Notification;
import com.concours.tools.Outils;
import com.gn.App;
import com.gn.GNAvatarView;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class login implements Initializable {

    @FXML
    private GNAvatarView avatar;
    @FXML private HBox box_username;
    @FXML private HBox box_password;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button login;

    @FXML private Label lbl_password;
    @FXML private Label lbl_username;
    @FXML private Label lbl_error;

    //private DB db = new DB();

    User user = new User();
    UserManager userM = new UserManager();

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(password);
        addEffect(username);

        setupListeners();

    }


    private void addEffect(Node node){
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!node.isFocused())
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            else node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });
    }

    private void setupListeners(){
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validPassword()){
                if(!newValue){
                    Flash swing = new Flash(box_password);
                    lbl_password.setVisible(true);
                    new SlideInLeft(lbl_password).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_password.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_password.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validUsername()){
                if(!newValue){
                    Flash swing = new Flash(box_username);
                    lbl_username.setVisible(true);
                    new SlideInLeft(lbl_username).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_username.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_username.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

    private boolean validPassword(){
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername(){
        return !username.getText().isEmpty() && username.getLength() > 3;
    }

    @FXML
    private void loginAction(ActionEvent event){
        String pseudo =username.getText();
        String pass = password.getText();

        if (validPassword() && validUsername()){
            User user = userM.get(pseudo,pass);
            if (user != null) {
                try {
                    Outils.load(event,"Tableau de bord","/com/concours/module/dashbord/dashbord.fxml");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            } else {
                Notification.NotifError("Erreur","Email ou Pass incorrect");
            }
        }


    }

    @FXML
    private void switchCreate(ActionEvent event){

        //App.decorator.setContent(ViewManager.getInstance().get("account"));
        try {
            Outils.load(event,"Enregistrez-vous","/com/concours/module/login/account.fxml");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}



package com.concours.module.login;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.concours.database.DB;
import com.concours.global.User;
import com.concours.global.plugin.UserManager;
import com.concours.global.util.Mask;
import com.concours.tools.Notification;
import com.concours.tools.Outils;
import com.gn.App;
import com.gn.GNAvatarView;

import javafx.animation.RotateTransition;
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

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class account implements Initializable {

    @FXML private GNAvatarView avatar;

    @FXML private HBox box_fullname;
    @FXML private HBox box_username;
    @FXML private HBox box_email;
    @FXML private HBox box_password;

    @FXML private TextField fullname;
    @FXML private TextField username;
    @FXML private TextField email;
    @FXML private TextField password;

    @FXML private Label lbl_password;
    @FXML private Label lbl_fullname;
    @FXML private Label lbl_email;
    @FXML private Label lbl_username;

    @FXML private Label lbl_error;

    @FXML private Button register;

    User user = new User();
    UserManager userM = new UserManager();
    DB db = new DB();

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(email);
        addEffect(fullname);
        addEffect(username);
        addEffect(password);

        Mask.nameField(fullname);
        Mask.noInitSpace(username);
        Mask.noSpaces(username);
        setupListeners();
    }

    @FXML
    private void register(ActionEvent event) throws Exception {
        Pulse pulse = new Pulse(register);
        pulse.setDelay(Duration.millis(20));
        pulse.play();

        if (validEmail() && validFullName() && validFullName() && validUsername() && validPassword()) {

            String pseudo = username.getText();
            String fname = fullname.getText();
            String mail = email.getText();
            String pass = password.getText();

            user= new User(pseudo,fname,mail,pass);
            User eUser = userM.getp(pseudo);
            if (eUser != null) {
                lbl_error.setVisible(true);
                Notification.NotifError("Erreur","Pseudo déjà utilisé choisissez un autre !");
            } else
            {
                //userM.save(user);
                db.callProcd(pseudo,fname,mail,pass);

                Notification.NotifSucces("Félicitation","Utilisateur ajouté avec Succes");
                Outils.load(event,"Tableau de bord","/com/concours/module/login/account.fxml");
            }

        } else if (!validUsername()){
            lbl_username.setVisible(true);
        } else if (!validFullName()) {
            lbl_fullname.setVisible(true);
        } else if (!validEmail()){
            lbl_email.setVisible(true);
        } else {
            lbl_password.setVisible(true);
        }
    }

    private void setProperties(){

    }

    @FXML
    private void back(ActionEvent event){
        try {
            Outils.load(event,"Tableau de bord","/com/concours/module/login/login.fxml");
        }catch (Exception ex){
            ex.printStackTrace();
        }
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

    private boolean validPassword(){
        return !password.getText().isEmpty() && password.getLength() > 3 ;
    }

    private boolean validUsername(){
        return !username.getText().isEmpty() && username.getLength() > 3 ;
    }

    private boolean validFullName(){
        return !fullname.getText().isEmpty() && fullname.getLength() > 3 ;
    }

    private boolean validEmail(){
        return Mask.isEmail(email);
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

        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validEmail()){
                if(!newValue){
                    Flash swing = new Flash(box_email);
                    lbl_email.setVisible(true);
                    new SlideInLeft(lbl_email).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_email.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_email.setVisible(false);
                }
            }  else {
                lbl_error.setVisible(false);
            }
        });

        fullname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validFullName()){
                if(!newValue){
                    Flash swing = new Flash(box_fullname);
                    lbl_fullname.setVisible(true);
                    new SlideInLeft(lbl_fullname).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_fullname.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_fullname.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }
}

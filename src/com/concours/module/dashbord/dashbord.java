package com.concours.module.dashbord;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.concours.database.DB;
import com.concours.entity.Planteur;
import com.concours.entity.PlanteurManager;
import com.concours.tools.Notification;
import com.concours.tools.Outils;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dashbord implements Initializable {

    final ObservableList options= FXCollections.observableArrayList();

    @FXML private StackPane Stack;

    @FXML private TextField img;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField email;
    @FXML private DatePicker dateN;
    @FXML private TextField lieuN;
    @FXML private TextField nation;
    @FXML private TextField contact;
    @FXML private TextField numDipl;
    @FXML private TextField numPc;
    @FXML private TextField imgPc;
    @FXML private TextField niveau;
    @FXML private ComboBox combo_diplome;
    @FXML private ComboBox combo_piece;
    @FXML private TextField diplome;
    @FXML private TextField localisation;
    @FXML private TextField superficie;
    @FXML private ComboBox combo_culture;
    @FXML private ComboBox combo_methode;
    @FXML private TextField certificat;
    @FXML private TextField employe;
    @FXML private TextField employeFem;
    @FXML private TextField imgPlt;
    @FXML private TextField salaire;
    @FXML private TextField age;
    @FXML private TextField emplCert;

    @FXML private TableView<Planteur> tableView;
    @FXML private TableColumn<Planteur, String> matriculeView;
    @FXML private TableColumn<Planteur, String> nomView;
    @FXML private TableColumn<Planteur, String> prenomView;
    @FXML private TableColumn<Planteur, String> naissView;
    @FXML private TableColumn<Planteur, String> lieuView;
    @FXML private TableColumn<Planteur, String> superficieView;
    @FXML private TableColumn<Planteur, String> cultureView;
    @FXML private TableColumn<Planteur, String> anneeView;
    @FXML private TableColumn<Planteur, String> avisView;





    Planteur planteur;
    PlanteurManager planteurM;

    private RotateTransition rotateTransition = new RotateTransition();

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(nom); addEffect(prenom); addEffect(email); addEffect(lieuN); addEffect(nation); addEffect(contact); addEffect(img); addEffect(numDipl);
        addEffect(numPc); addEffect(imgPc); addEffect(niveau); addEffect(combo_diplome); addEffect(diplome); addEffect(localisation); addEffect(superficie);
        addEffect(combo_culture); addEffect(combo_methode); addEffect(certificat);addEffect(combo_piece); addEffect(employe); addEffect(employeFem);
        addEffect(imgPlt); addEffect(salaire); addEffect(age); addEffect(emplCert);

        img.setEditable(false); imgPc.setEditable(false); certificat.setEditable(false); diplome.setEditable(false); emplCert.setEditable(false);
        imgPlt.setEditable(false);



        //matriculeView.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        //nomView.setCellValueFactory(new PropertyValueFactory<>("matricule"));


        // setupListeners();
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

    DB db = new DB();
    @FXML
    private void addPieceType(ActionEvent event)
    {
        String sql="Select libelle_piece From type_piece";
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            if(rs.next()){
                options.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    private void addDiplType()
    {
        String sql="Select libelle_diplome From type_diplome";
        try {
            db.initPrepar(sql);

            ResultSet rs = db.executeSelect();
            if(rs.next()){
                options.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    private void addCulture(){}

    @FXML
    private void addMethode(){}

    @FXML
    private void addPhoto(ActionEvent event)
    {
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        img.setText(file.toString());

    }

    @FXML
    private void addDiplome(ActionEvent event)
    {
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        diplome.setText(file.toString());
    }

    @FXML
    private void addPiece(ActionEvent event)
    {
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        imgPc.setText(file.toString());
    }

    @FXML
    private void addCertificat(ActionEvent event){
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        if (!file.toString().isEmpty())
        certificat.setText(file.toString());
    }

    @FXML
    private void addPlant(){
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        if (!file.toString().isEmpty())
            imgPlt.setText(file.toString());
    }

    @FXML
    private void addDecl(){
        FileChooser choose = new FileChooser();
        choose.setTitle("Choisir une image");
        Stage stage = (Stage)Stack.getScene().getWindow();

        File file= choose.showOpenDialog(stage);
        if (!file.toString().isEmpty())
            emplCert.setText(file.toString());
    }

    private boolean validInscription(){
        return !img.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !email.getText().isEmpty() &&
                !dateN.getEditor().getText().isEmpty() && !lieuN.getText().isEmpty() && !nation.getText().isEmpty() &&
                !contact.getText().isEmpty() && !numDipl.getText().isEmpty() && !niveau.getText().isEmpty() && !diplome.getText().isEmpty() &&
                !imgPc.getText().isEmpty() && !combo_diplome.getEditor().getText().isEmpty() && !combo_piece.getEditor().getText().isEmpty() &&
                !localisation.getText().isEmpty() && !superficie.getText().isEmpty() && !combo_culture.getEditor().getText().isEmpty() &&
                !combo_methode.getEditor().getText().isEmpty() && !age.getText().isEmpty() && !salaire.getText().isEmpty() &&
                !imgPlt.getText().isEmpty() && !certificat.getText().isEmpty() && !employe.getText().isEmpty() &&
                !numPc.getText().isEmpty() && !employeFem.getText().isEmpty() && !emplCert.getText().isEmpty();
    }

    @FXML
    private void enregistrer(ActionEvent event){
        planteur = new Planteur();
        planteurM = new PlanteurManager();

        planteur.setMatricule( "PTL");
        planteur.setNom( nom.getText());
        planteur.setPrenom( prenom.getText());
        planteur.setEmail( email.getText());
        planteur.setDateN( dateN.getEditor().getText());
        planteur.setLieuN( lieuN.getText());
        planteur.setNation( nation.getText());
        planteur.setContact( contact.getText());
        planteur.setImg(img.getText());
        planteur.setNumDipl(numDipl.getText());
        planteur.setNumPc(numPc.getText());
        planteur.setImgPc( imgPc.getText());
        planteur.setNiveau( niveau.getText());
        planteur.setTypeDipl(combo_diplome.getEditor().getText());
        planteur.setTypePiec(combo_piece.getEditor().getText());
        planteur.setDiplome( diplome.getText());
        planteur.setLocalisation( localisation.getText());
        planteur.setSuperficie( superficie.getText());
        planteur.setCulture(combo_culture.getEditor().getText());
        planteur.setMethode(combo_methode.getEditor().getText());
        planteur.setCertificat( certificat.getText());
        planteur.setEmploye( employe.getText());
        planteur.setEmployeFem( employeFem.getText());
        planteur.setImgPlt( imgPlt.getText());
        planteur.setSalaire( salaire.getText());
        planteur.setAge( age.getText());
        planteur.setEmplCert( emplCert.getText());



        int ok = planteurM.add(planteur);
        if (ok != 0 && validInscription()) {
            Notification.NotifSucces("Super", "Vous avez ajouter un Candidat");
            //load();
        } else {
            Notification.NotifError("Erreur", "Veuillez saisir tous les champs");
        }

    }
}

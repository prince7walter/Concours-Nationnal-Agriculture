package com.concours.module.dashbord;


import animatefx.animation.Pulse;
import com.concours.database.DB;
import com.concours.entity.*;
import com.concours.tools.Notification;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

public class dashbord implements Initializable {

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





    private Planteur planteur;
    private PlanteurManager planteurM = new PlanteurManager();
    private DiplomeType diplomeEntite;
    private DiplomeTypeManger diplomeM = new DiplomeTypeManger();
    private PieceType pieceType;
    private PieceTypeManager pieceTypeM = new PieceTypeManager();
    private CultureType cultureType;
    private CultureTypeManager cultureTypeM = new CultureTypeManager();
    private Methode methodeEntite;
    private MethodeManager methodeM = new MethodeManager();

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

        addPieceType();
        addDiplType(); addCulture(); addMethode();

        //matriculeView.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        //prenomView.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        naissView.setCellValueFactory(new PropertyValueFactory<>("dateN"));
        lieuView.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        superficieView.setCellValueFactory(new PropertyValueFactory<>("superficie"));
        cultureView.setCellValueFactory(new PropertyValueFactory<>("culture"));
        avisView.setCellValueFactory(new PropertyValueFactory<>("lieun"));
        //loadPlanteur();

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
    private void addPieceType()
    {
        db.getConnection();
        ResultSet rs;
        String sql="Select libelle_type_piece From type_piece";

        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            combo_piece.getItems().add("");
            while (rs.next()){
                combo_piece.getItems().add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    private void addDiplType()
    {
        db.getConnection();
        ResultSet rs;
        String sql="Select libelle_diplome From type_diplome";

        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            combo_diplome.getItems().add("");
            while (rs.next()){
                combo_diplome.getItems().add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void addCulture()
    {
        db.getConnection();
        ResultSet rs;
        String sql="Select libelle_type_culture From type_culture";

        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            combo_culture.getItems().add("");
            while (rs.next()){
                combo_culture.getItems().add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void addMethode()
    {
        db.getConnection();
        ResultSet rs;
        String sql="Select libelle_methode From methode_culture";

        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            combo_methode.getItems().add("");
            while (rs.next()){
                combo_methode.getItems().add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

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
                !imgPc.getText().isEmpty() && !localisation.getText().isEmpty() && !superficie.getText().isEmpty() &&
                !age.getText().isEmpty() && !salaire.getText().isEmpty() && !imgPlt.getText().isEmpty() &&
                !certificat.getText().isEmpty() && !employe.getText().isEmpty() && !numPc.getText().isEmpty() &&
                !employeFem.getText().isEmpty() && !emplCert.getText().isEmpty();
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
        planteur.setTypeDipl(combo_diplome.getSelectionModel().getSelectedIndex());
        planteur.setTypePiec(combo_piece.getSelectionModel().getSelectedIndex());
        planteur.setDiplome( diplome.getText());
        planteur.setLocalisation( localisation.getText());
        planteur.setSuperficie( superficie.getText());
        planteur.setCulture(combo_culture.getSelectionModel().getSelectedIndex());
        planteur.setMethode(combo_methode.getSelectionModel().getSelectedIndex());
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
            clearvalue();
        } else {
            Notification.NotifError("Erreur", "Veuillez saisir tous les champs");
        }
    }

    public void loadPlanteur()
    {
        ObservableList<Planteur> planteurs = FXCollections.observableArrayList();
        List<Planteur> planteurList =planteurM.get();
        for (Planteur p : planteurList){
            planteurs.add(p);
        }
        tableView.setItems(planteurs);
    }

    public void clearvalue(){
        img.setText(""); nom.setText(""); prenom.setText(""); email.setText(""); dateN.getEditor().setText("");
        lieuN.setText(""); nation.setText(""); contact.setText(""); numDipl.setText(""); numPc.setText(""); imgPc.setText("");
        niveau.setText(""); combo_diplome.setValue(""); combo_piece.setValue(""); diplome.setText("");
        localisation.setText(""); superficie.setText(""); combo_culture.setValue(""); combo_methode.setValue("");
        certificat.setText(""); employe.setText(""); employeFem.setText(""); imgPlt.setText(""); salaire.setText(""); age.setText("");
        emplCert.setText("");
    }
}

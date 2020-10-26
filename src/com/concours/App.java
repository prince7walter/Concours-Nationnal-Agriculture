package com.concours;


import com.gn.decorator.GNDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    //public static final GNDecorator decorator = new GNDecorator();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/concours/module/dashbord/menu.fxml"));
        primaryStage.setTitle("Concours Nationnale de l'Agriculture");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }


    public static void main(String[] args) {
        launch(args);
    }

}

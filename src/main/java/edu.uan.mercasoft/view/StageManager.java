package edu.uan.mercasoft.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class StageManager {
    private Locale location;
    private Stage primaryStage;
    private ResourceBundle languageResources;

    public StageManager(Stage primaryStage) {
        this.primaryStage=primaryStage;
    }


    public void switchScene(FXMLView view){
        Parent root = null;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource(view.getFxmlFile()));
            loader.setResources(languageResources);
            loader.setController(view.getController(this));
            primaryStage.setTitle(languageResources.getString("AppName"));
            root=loader.load();
            showScene(root,view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showScene(final Parent root,final FXMLView view){
        Scene scene=new Scene(root, view.getWidth(), view.getHeight());
        scene.setRoot(root);
        String  estilo= getClass().getClassLoader().getResource("styles/login.css").toExternalForm();
        scene.getStylesheets().add(estilo);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public void setLocation(String location) {
        this.location = new Locale(location,"CO");
        Locale.setDefault(this.location);
        this.languageResources=ResourceBundle.getBundle("string");
    }

    public void  openDialogWindow(final FXMLView view ){
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view.getFxmlFile()));
        loader.setResources(languageResources);
        loader.setController(view.getController(this));
        Stage stage = new Stage();
        Scene scene = new Scene(root, view.getWidth(), view.getHeight());
        stage.setScene(scene);
        stage.show();

    }

}

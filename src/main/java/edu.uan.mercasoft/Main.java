package edu.uan.mercasoft;

import edu.uan.mercasoft.view.FXMLView;
import edu.uan.mercasoft.view.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageManager stageManager=new StageManager(primaryStage);
        stageManager.setLocation("es");
        stageManager.switchScene(FXMLView.LOGIN);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
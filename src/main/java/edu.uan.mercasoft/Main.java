package edu.uan.mercasoft;

import edu.uan.mercasoft.repository.JPAImpl.JPAUserRepositoryImpl;
import edu.uan.mercasoft.view.FXMLView;
import edu.uan.mercasoft.view.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StageManager stageManager=new StageManager(primaryStage);
        stageManager.setLocation("es");
        JPAUserRepositoryImpl initBasicUser=new JPAUserRepositoryImpl();
        initBasicUser.saveUser("C46D76F62D2441BD0F314E016FF14BC37F204465D213391EF1F2D8A286A79061");
        stageManager.switchScene(FXMLView.LOGIN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
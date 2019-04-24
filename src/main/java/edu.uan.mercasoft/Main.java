package edu.uan.mercasoft;

import edu.uan.mercasoft.repository.JPAUserRepositoryImpl;
import edu.uan.mercasoft.view.FXMLView;
import edu.uan.mercasoft.view.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageManager stageManager=new StageManager(primaryStage);
        stageManager.setLocation("es");
        JPAUserRepositoryImpl initBasicUser=new JPAUserRepositoryImpl();
        initBasicUser.saveUser("9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08");
        stageManager.switchScene(FXMLView.LOGIN);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
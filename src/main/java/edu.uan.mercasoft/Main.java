package edu.uan.mercasoft;

import edu.uan.mercasoft.controllers.QuickConstructionController;
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
        QuickConstructionController constructor= new QuickConstructionController();
        //constructor.loadBasicUser();
        //constructor.loadBasicProducts();
        //constructor.loadBasicCustomers();
        stageManager.switchScene(FXMLView.LOGIN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
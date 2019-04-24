package edu.uan.mercasoft.view;

import edu.uan.mercasoft.controllers.LoginController;
import edu.uan.mercasoft.controllers.MainController;

import java.util.ResourceBundle;

public enum FXMLView {

    MAIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("main.app.title");
        }

        @Override
        String getFxmlFile() {
            return "MainContainer.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new MainController(stage);
        }
        @Override
        int getWidth(){return 600;}

        @Override
        int getHeight() {
            return 450;
        }
    },
    LOGIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        String getFxmlFile() {
            return "/layout/Login2.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new LoginController();
        }
        @Override
        int getWidth(){return 600;}

        @Override
        int getHeight() {
            return 400;
        }
    };

    abstract String getTitle();
    abstract String getFxmlFile();
    abstract Object getController(StageManager stage);
    abstract int getWidth();
    abstract int getHeight();
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}

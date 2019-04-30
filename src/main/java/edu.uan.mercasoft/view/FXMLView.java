package edu.uan.mercasoft.view;

import edu.uan.mercasoft.controllers.LoginController;
import edu.uan.mercasoft.controllers.MainController;
import edu.uan.mercasoft.controllers.SaleController;

import java.util.ResourceBundle;

public enum FXMLView {

    MAIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("main.app.title");
        }

        @Override
        String getFxmlFile() {
            return "/layout/MainContainer.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new MainController(stage);
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
            return new LoginController(stage);
        }

        @Override
        int getWidth() {
            return 400;
        }

        @Override
        int getHeight() {
            return 540;
        }
    },

    SALE{
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        String getFxmlFile() {
            return "/layout/SaleTab.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new SaleController();
        }

    };


    abstract String getTitle();
    abstract String getFxmlFile();
    abstract Object getController(StageManager stage);
    int getWidth(){return 600;}
    int getHeight(){return 480;}
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}

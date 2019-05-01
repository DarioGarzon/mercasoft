package edu.uan.mercasoft.view;

import edu.uan.mercasoft.controllers.BillReadController;
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
            return "/layout/Login.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new LoginController(stage);
        }

        @Override
        int getWidth() {
            return 380;
        }

        @Override
        int getHeight() {
            return 470;
        }
    },
    BILLREAD {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        String getFxmlFile() {
            return "/layout/Bill_Read.fxml";
        }
        @Override
        Object getController(StageManager stage) {
            return new BillReadController(stage);
        }

        @Override
        int getWidth() {
            return 250;
        }

        @Override
        int getHeight() {
            return 350;
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
    int getWidth(){return 620;}
    int getHeight(){return 670;}
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}

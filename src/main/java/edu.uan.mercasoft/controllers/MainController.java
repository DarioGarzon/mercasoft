package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.view.StageManager;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabSaleId;
    @FXML
    private Tab tabBillId;

    @FXML
    private BillController tabBillController;
    @FXML
    private VBox tabBill;
    @FXML
    private SaleController tabSaleController;

    public MainController(StageManager stage) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
                switchTabs(newValue);
                });

    }

    private void switchTabs(Tab newTag) {
        tabSaleController.cleanFields();
        switch (newTag.getId()){
            case "tabSaleId":
                break;
            case "tabBillId":
                tabBillController.loadBills();
                break;
            default:
                break;
        }
        int i=0;
    }
}

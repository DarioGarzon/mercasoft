package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.domain.BillDetail;
import edu.uan.mercasoft.useCases.ISaleInteractor;
import edu.uan.mercasoft.useCases.SaleInteractorImpl;
import edu.uan.mercasoft.view.GenericCellFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BillController implements Initializable {
    private ObservableList<Bill> filteredBills= FXCollections.observableArrayList();
    private ObservableList<Bill>simpleBillList = FXCollections.observableArrayList();
    private ISaleInteractor facturator;
    private List<Bill> billList= new ArrayList<>();
    ContextMenu menu = new ContextMenu();
    MenuItem item = new MenuItem("View Person");


    @FXML
    private TextField txt_billId_search;

    @FXML
    private TextField txt_customer_search;

    @FXML
    private TableView billTableList;

    @FXML
    private TableColumn<Bill,String> billTableListColumn1;

    @FXML
    private TableColumn<Bill,String> billTableListColumn2;

    @FXML
    private TableColumn<Bill,String> billTableListColumn3;

    @FXML
    private TableColumn<Bill,String> billTableListColumn4;
    @FXML
    private TableColumn<Bill,String> billTableListColumn5;

    @FXML
    private void filtterById(){
        if (!txt_billId_search.getText().trim().isEmpty()){
            List<Bill> tempList=billList.stream().filter(x->Integer.toString(x.getId()).equals(txt_billId_search.getText().trim())).collect(Collectors.toList());
            filteredBills.setAll(tempList);
        }
        else{
            filteredBills.setAll(billList);
        }
    }

    public BillController() {
        this.facturator = new SaleInteractorImpl();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_billId_search.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                filtterById();
            }
        });
        txt_customer_search.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                filtterByCustomer();
            }
        });
        //orders.put("Test",testOrder);
        bindCustomTable();
    }

    private void filtterByCustomer() {
        if (!txt_customer_search.getText().trim().isEmpty()){
            List<Bill> tempList= billList.stream().filter(bill -> bill.getBuyer()!=null)
                    .filter(bill->txt_customer_search.getText().trim().equals(bill.getBuyer().getDocumentNumber()))
                    .collect(Collectors.toList());
            filteredBills.setAll(tempList);
        }
        else{
            filteredBills.setAll(billList);
        }
    }


    private void bindCustomTable() {
        item.setOnAction((EventHandler) t -> System.out.println("person" + 1));
        menu.getItems().addAll(item);

        TableColumn<Bill,String> idColumn = new TableColumn<>("Id");
        billTableListColumn1.setCellValueFactory(new PropertyValueFactory<Bill, String>("Id"));
        GenericCellFactory cellFactory = new GenericCellFactory(click, menu);
        //billTableListColumn1.setCellFactory(cellFactory);
        billTableListColumn2.setCellValueFactory(param->new SimpleStringProperty(param.getValue().getDate().toString()));


        billTableListColumn3.setCellValueFactory(param->
        new SimpleStringProperty(String.valueOf(param.getValue().getBuyer())));

        billTableListColumn4.setCellValueFactory(param->
                new SimpleStringProperty(String.valueOf(param.getValue().getTotalValue())));
        billTableListColumn5.setCellValueFactory(param->
                new SimpleStringProperty(param.getValue().getSeller().toString()));
        billTableList.setItems(filteredBills);

    }

    public void loadBills(){
        billList.clear();
        billList=facturator.getBills();
        filteredBills.clear();
        //filteredBills.removeAll(filteredBills);
        filteredBills.addAll(billList);
        billTableList.refresh();
    }


    EventHandler click = t -> {
        if(((MouseEvent)t).getClickCount() == 2) {
            System.out.println("person" + 2);
        }
    };


}

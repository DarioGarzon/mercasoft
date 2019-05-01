package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.Session;
import edu.uan.mercasoft.domain.*;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.repository.JPAImpl.JPACustomerRepositoryImpl;
import edu.uan.mercasoft.repository.JPAImpl.JPAProductRepositoryImpl;
import edu.uan.mercasoft.useCases.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URL;
import java.util.*;

public class SaleController implements Initializable {

    private ObservableMap<String, BillDetail> orders=FXCollections.observableHashMap();
    private ObservableList<Map.Entry<String, BillDetail>> orderList = FXCollections.observableArrayList();
    private ISaleInteractor facturator;
    private ILoyaltyInteractor loyaler;
    private RegularCustomer customer;
    private IInventoryInteractor inventoryActuator;
    private Bill actualTransaction;

    @FXML
    private TextField txt_sku_search;

    @FXML
    private TextField txt_customer_search;

    @FXML
    private TableView orderDetailList;

    @FXML
    private Text txt_total_tax;

    @FXML
    private Text txt_total_price;

    @FXML
    private Text txt_net_price;

    @FXML
    private Text txt_regular_customer;

    public SaleController() {
        facturator= new SaleInteractorImpl();
        loyaler=new LoyaltyInteractorImpl();
        inventoryActuator= new InventoryInteractorImpl();
        actualTransaction= new Bill(Session.getInstance().getActualUser());
    }

    @FXML
    private void searchProduct()  {
        txt_regular_customer.setVisible(false);
        try{
            if(txt_sku_search.getText().trim().isEmpty()){
                txt_regular_customer.setVisible(true);
                txt_regular_customer.setText("Por favor digite el codigo de producto a buscar");
            }
            else{
                Product readenProduct =facturator.searchProduct(txt_sku_search.getText().trim());
                addToOrder(readenProduct);
            }
        }catch (NotFoundProduct noProduct){
            txt_regular_customer.setVisible(true);
            txt_regular_customer.setText("Producto no encontrado");
        }
    }


    @FXML
    private void searchCustomer(ActionEvent action){
        searchCustomer();
    }

    private void searchCustomer(){
        txt_regular_customer.setVisible(false);
        if(txt_customer_search.getText().trim().isEmpty()){
            txt_regular_customer.setVisible(true);
            txt_regular_customer.setText("Por favor digite un numero de documento a buscar");
        }
        else{
            try{
                RegularCustomer foundClient= loyaler.findCustomer(txt_customer_search.getText().trim());
                txt_regular_customer.setVisible(true);
                txt_regular_customer.setText(foundClient.getName()+ " "+ foundClient.getLastName());
                this.customer=foundClient;
            }
            catch (NotFoundCustomer nocustomer ){
                txt_regular_customer.setVisible(true);
                txt_regular_customer.setText("Cliente no encontrado");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_sku_search.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                searchProduct();
            }
        });
        txt_customer_search.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                searchCustomer();
            }
        });
        //orders.put("Test",testOrder);
        bindCustomTable();
    }

    private void bindCustomTable() {

        TableColumn<Map.Entry<String, BillDetail>, String> skuColumn = new TableColumn<>("SKU");
        skuColumn.setCellValueFactory(param->new SimpleStringProperty(param.getValue().getKey()));
        TableColumn<Map.Entry<String, BillDetail>, String> productNameColumn = new TableColumn<>("Producto");
        productNameColumn.setCellValueFactory(param->new SimpleStringProperty(param.getValue().getValue().getProduct().getName()));
        TableColumn<Map.Entry<String, BillDetail>, String> unitPriceColumn = new TableColumn<>("Precion Unitario");
        unitPriceColumn.setCellValueFactory(param->new SimpleStringProperty(String.valueOf(param.getValue().getValue().getProduct().getPrice())));
        TableColumn<Map.Entry<String, BillDetail>, String> quantityColumn = new TableColumn<>("Cantidad");
        quantityColumn.setCellValueFactory(param->new SimpleStringProperty(String.valueOf(param.getValue().getValue().getQuantity())));
        TableColumn<Map.Entry<String, BillDetail>, String> orderPriceColumn = new TableColumn<>("Precio");
        orderPriceColumn.setCellValueFactory(param->new SimpleStringProperty(String.valueOf(param.getValue().getValue().getOrderPrice())));

        orderDetailList.setItems(orderList);
        orders.addListener((MapChangeListener<String, BillDetail>) change -> {
            orderList.removeAll(orders.entrySet());
            orderList.addAll(orders.entrySet());
            updateTotalValues(orders);
        });
        orderDetailList.getColumns().setAll(skuColumn,productNameColumn,unitPriceColumn,quantityColumn,orderPriceColumn);
        orderDetailList.getColumns().set(0,skuColumn);
    }

    private void updateTotalValues(ObservableMap<String, BillDetail> orders) {
        float total_price;
        float total_tax=0;
        float net_price=0;
        for (Map.Entry<String, BillDetail> entry : orders.entrySet()) {
            net_price+=entry.getValue().getOrderPrice();
            total_tax+=net_price*entry.getValue().getProduct().getAppliedTax()/100;
        }
        total_price=net_price+total_tax;
        txt_total_price.setText(String.valueOf(total_price));
        txt_net_price.setText(String.valueOf(net_price));
        txt_total_tax.setText(String.valueOf(total_tax));
    }

    private void addToOrder(Product product){
        if(!orders.containsKey(product.getProductCode())){
            BillDetail newDetail= new BillDetail(product,(short)1,0,product.getPrice());
            orders.put(product.getProductCode(),newDetail);
        }
        else{
            BillDetail orderToAddQuantity=orders.get(product.getProductCode());
            orders.remove(product.getProductCode());
            float discount=facturator.checkDiscountByQuantity(product,orderToAddQuantity.getQuantity()+1);
            orderToAddQuantity.setDiscount(discount);
            orderToAddQuantity.setQuantity((short) (orderToAddQuantity.getQuantity()+1));
            orders.put(product.getProductCode(),orderToAddQuantity);
        }
    }

    public void concreteBill(ActionEvent actionEvent) {
        List<BillDetail> details= new ArrayList<BillDetail>();
        for (Map.Entry<String, BillDetail> entry : orders.entrySet()) {
            details.add(entry.getValue());
        }
        actualTransaction= new Bill(0,Float.parseFloat(txt_total_price.getText()),
                details,Session.getInstance().getActualUser(),customer,new Date());
        inventoryActuator.subtracteProducts(details);
        facturator.saveTransaction(actualTransaction);
        cleanFields();
        showMessage("Compra realizada con exito");
    }

    private void showMessage(String message) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Text textToPost= new Text(message);
        Button confirmButton=new Button("Ok");
        confirmButton.setOnAction(actionEvent->dialogStage.close());
        VBox vbox = new VBox(textToPost,confirmButton );
        dialogStage.setTitle("Compra Exitosa");
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40));
        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }


    public void cleanFields(){
        customer=null;
        orderList.clear();
        orders.clear();
        txt_sku_search.clear();
        txt_customer_search.clear();
        txt_regular_customer.setVisible(false);
    }
}

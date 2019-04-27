package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.StockProduct;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.useCases.IInventoryInteractor;
import edu.uan.mercasoft.useCases.InventoryInteractorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;

public class ProductAdquisitionController {

    private List<Product> productList;
    private IInventoryInteractor inventory;

    public ProductAdquisitionController() {
        inventory= new InventoryInteractorImpl(this);
    }

    public void adquireProducts() throws NotFoundProduct {
        inventory.addProducts(productList);
    }
}

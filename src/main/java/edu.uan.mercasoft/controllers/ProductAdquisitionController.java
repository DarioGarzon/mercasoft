package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.useCases.IInventoryInteractor;
import edu.uan.mercasoft.useCases.InventoryInteractorImpl;

import java.util.List;

public class ProductAdquisitionController {

    private List<Product> productList;
    private IInventoryInteractor inventory;

    public ProductAdquisitionController() {
        inventory= new InventoryInteractorImpl();
    }

    public void adquireProducts() throws NotFoundProduct {
        inventory.addProducts(productList);
    }
}

package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.useCases.IInventoryInteractor;
import edu.uan.mercasoft.useCases.InventoryInteractorImpl;

import java.util.List;

public class ProductListingController {
    private String idProduct;
    private IInventoryInteractor inventory;

    public ProductListingController()
    {
        inventory = new InventoryInteractorImpl();
    }

    public List<Product> listProduct() throws NotFoundProduct
    {
        return inventory.getProducts();
    }
}

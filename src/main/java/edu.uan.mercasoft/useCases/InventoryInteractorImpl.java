package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.ProductAdquisitionController;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.StockProduct;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public class InventoryInteractorImpl implements IInventoryInteractor {
    private ProductAdquisitionController controller;
    private PersistenceFacade persistence;

    public InventoryInteractorImpl(ProductAdquisitionController productAdquisitionController) {
        this.controller=productAdquisitionController;
        persistence= new PersistenceFacade();
    }

    public List<Product> getProducts(ProductAdquisitionController productAdquisitionController) throws NotFoundProduct {
        return product;
    }

    @Override
    public void addProducts(List<Product> productList) throws NotFoundProduct {
        for (Product productToUpdate:productList) {
            persistence.updateStock(productToUpdate);
        }

    }
}

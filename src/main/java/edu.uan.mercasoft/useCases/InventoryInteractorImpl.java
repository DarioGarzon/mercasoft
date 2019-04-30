package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.ProductAdquisitionController;
import edu.uan.mercasoft.controllers.ProductListingController;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.StockProduct;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public class InventoryInteractorImpl implements IInventoryInteractor {

    private PersistenceFacade persistence;

    public InventoryInteractorImpl() {
        persistence= new PersistenceFacade();
    }


    public List<Product> getProducts() throws NotFoundProduct {
        return  persistence.getProducts();
    }

    @Override
    public void addProducts(List<Product> productList) throws NotFoundProduct {
        for (Product productToUpdate:productList) {
            persistence.updateStock(productToUpdate);
        }

    }
}

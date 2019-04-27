package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.StockProduct;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public interface IInventoryInteractor {
    void addProducts(List<Product> productList) throws NotFoundProduct;
}

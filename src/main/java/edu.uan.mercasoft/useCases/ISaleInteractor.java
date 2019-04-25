package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

public interface ISaleInteractor {
    Product searchProduct(String productCode) throws NotFoundProduct;

    float checkDiscountByQuantity(Product product, double quantity);
}
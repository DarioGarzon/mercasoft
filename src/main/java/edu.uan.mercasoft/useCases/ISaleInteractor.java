package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public interface ISaleInteractor {
    Product searchProduct(String productCode) throws NotFoundProduct;

    float checkDiscountByQuantity(Product product, double quantity);

    void saveTransaction(Bill actualTransaction);

    List<Bill> getBills();
}

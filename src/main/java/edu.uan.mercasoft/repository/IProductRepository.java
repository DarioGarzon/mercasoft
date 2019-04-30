package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;
import edu.uan.mercasoft.domain.StockProduct;
import edu.uan.mercasoft.domain.Supplier;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public interface IProductRepository {
    Product getActualProduct(String productCode) throws NotFoundProduct;

    void saveProduct(Product product);

    void updateProduct(Product productToUpdate);

    List<Product> getProducts();

    void saveSupplier(Supplier supplierToSave);

    void saveProductType(ProductType productType);

}

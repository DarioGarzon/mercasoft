package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;
import edu.uan.mercasoft.domain.Supplier;

public interface IProductManagementInteractor {
    void saveSupplier(Supplier supplierToAdd);

    void saveProductType(ProductType productType);

    void saveProduct(Product productToLoad);
}

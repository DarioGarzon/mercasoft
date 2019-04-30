package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;
import edu.uan.mercasoft.domain.Supplier;

public class ProductManagementInteractorImpl implements IProductManagementInteractor {
    private PersistenceFacade persistenceFacade;

    public ProductManagementInteractorImpl() {
        this.persistenceFacade = new PersistenceFacade();
    }

    @Override
    public void saveSupplier(Supplier supplierToAdd){
        persistenceFacade.saveSupplier(supplierToAdd);
    }

    @Override
    public void saveProductType(ProductType productType) {
        persistenceFacade.saveProductType(productType);
    }

    @Override
    public void saveProduct(Product productToLoad) {
        persistenceFacade.saveProduct(productToLoad);
    }
}

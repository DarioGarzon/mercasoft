package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.SaleController;
import edu.uan.mercasoft.domain.BusinessFacade;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

public class SaleInteractorImpl implements ISaleInteractor {

    private SaleController controller;
    private PersistenceFacade persistenceFacade;
    private BusinessFacade businessFacade;

    public SaleInteractorImpl(SaleController controller) {
        this.controller=controller;
        persistenceFacade= new PersistenceFacade();
        businessFacade= new BusinessFacade();
    }

    @Override
    public Product searchProduct(String productCode) throws NotFoundProduct {
        return persistenceFacade.getActualProduct(productCode);
    }

    @Override
    public float checkDiscountByQuantity(Product product, double quantity){
        return businessFacade.checkDiscountByQuantity(product,quantity);
    }
}

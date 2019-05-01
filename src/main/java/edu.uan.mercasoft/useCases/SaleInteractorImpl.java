package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.SaleController;
import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.domain.BusinessFacade;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;

import java.util.List;

public class SaleInteractorImpl implements ISaleInteractor {


    private PersistenceFacade persistenceFacade;
    private BusinessFacade businessFacade;

    public SaleInteractorImpl() {

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

    @Override
    public void saveTransaction(Bill actualTransaction) {

        persistenceFacade.saveTransaction(actualTransaction);
    }

    @Override
    public List<Bill> getBills() {
        return persistenceFacade.getBills();
    }
}

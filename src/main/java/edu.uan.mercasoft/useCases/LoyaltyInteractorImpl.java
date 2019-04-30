package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.SaleController;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;

public class LoyaltyInteractorImpl implements ILoyaltyInteractor {
    private PersistenceFacade persistenceFacade;

    public LoyaltyInteractorImpl() {
        this.persistenceFacade= new PersistenceFacade();
    }

    @Override
    public RegularCustomer findCustomer(String documentNumber) throws NotFoundCustomer {
        return persistenceFacade.findCustomerByDocument(documentNumber);
    }

    @Override
    public void saveCustomer(RegularCustomer customerToLoad) {
        persistenceFacade.saveRegularCustomer(customerToLoad);
    }
}

package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.controllers.SaleController;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;

public class LoyaltyInteractorImpl implements ILoyaltyInteractor {
    private SaleController controller;
    private PersistenceFacade persistenceFacade;

    public LoyaltyInteractorImpl(SaleController controller) {
        this.controller=controller;
        this.persistenceFacade= new PersistenceFacade();
    }

    @Override
    public RegularCustomer findCustomer(String documentNumber) throws NotFoundCustomer {
        return persistenceFacade.findCustomerByDocument(documentNumber);
    }
}

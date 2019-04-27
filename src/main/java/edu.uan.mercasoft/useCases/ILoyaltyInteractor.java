package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;

public interface ILoyaltyInteractor {


    public RegularCustomer findCustomer(String documentNumber ) throws NotFoundCustomer;
}

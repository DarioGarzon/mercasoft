package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;

public interface ICustomerRepository {
    RegularCustomer getCustomerByDocument(String documentNumber) throws NotFoundCustomer;
    void saveCustomer(RegularCustomer customerToSave);
}

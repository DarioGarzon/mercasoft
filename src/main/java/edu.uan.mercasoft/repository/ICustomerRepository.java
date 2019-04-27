package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.RegularCustomer;

public interface ICustomerRepository {
    RegularCustomer getCustomerByDocument(String documentNumber);
}

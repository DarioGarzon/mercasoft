package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.Bill;

public interface IBillRepository {
    void saveTransaction(Bill billToSave);
}

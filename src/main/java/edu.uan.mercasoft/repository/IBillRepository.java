package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.Bill;

import java.util.List;

public interface IBillRepository {
    void saveTransaction(Bill billToSave);

    List<Bill> getBills();
}

package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.StockProduct;

public interface IInventoryRepository {

    void addNewStock(StockProduct stock);

    void updateStock(Product foundStock);
}

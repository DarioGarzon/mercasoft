package edu.uan.mercasoft.domain;

import java.util.List;

public class Sale {
    private int id;
    private float totalValue;
    private List<SaleDetail> detailList;
    private User seller;
    private RegularCustomer buyer;

}

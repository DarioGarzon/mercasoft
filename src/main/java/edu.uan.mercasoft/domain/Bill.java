package edu.uan.mercasoft.domain;

import java.util.Date;
import java.util.List;

public class Bill {
    private int id;
    private float totalValue;
    private List<BillDetail> detailList;
    private User seller;
    private RegularCustomer buyer;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public List<BillDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BillDetail> detailList) {
        this.detailList = detailList;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public RegularCustomer getBuyer() {
        return buyer;
    }

    public void setBuyer(RegularCustomer buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bill(User seller) {
        this.seller = seller;
    }

    public Bill(int id,float totalValue, List<BillDetail> detailList, User seller, RegularCustomer buyer,Date date) {
        this.id=id;
        this.totalValue = totalValue;
        this.detailList = detailList;
        this.seller = seller;
        this.buyer = buyer;
        this.date=date;
    }
    public Bill(int id,float totalValue, List<BillDetail> detailList, User seller,Date date) {
        this(id,totalValue,detailList,seller,null,date);
    }


}

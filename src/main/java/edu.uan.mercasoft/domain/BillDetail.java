package edu.uan.mercasoft.domain;

public class BillDetail {

    private Product product;
    private short quantity;
    private float discount;
    private float orderPrice;

    public float getOrderPrice() {
        return (product.getPrice()*quantity*(1-discount));
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BillDetail(Product product, short quantity, float discount, float orderPrice) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.orderPrice = orderPrice;
    }
}

package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.BillDetail;
import edu.uan.mercasoft.domain.Product;

import javax.persistence.*;

@Entity
@Table(name = "Bill_Detail")
@NamedQueries({
        @NamedQuery(name = "BillDetailDTO.findById",
                query = "SELECT c FROM BillDetailDTO c WHERE c.id = : billId"),
}
)
public class BillDetailDTO {
    private int id;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private ProductDTO product;
    private short quantity;
    private float discount;
    private float orderPrice;

    public float getOrderPrice() {
        if(product==null) return 0;
        return (product.getPrice()*quantity*(1-discount));
    }


    @ManyToOne(cascade = CascadeType.ALL)
    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
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

    public BillDetailDTO(Product product, short quantity, float discount, float orderPrice) {
        this.product = new ProductDTO(product);
        this.quantity = quantity;
        this.discount = discount;
        this.orderPrice = orderPrice;
    }

    public BillDetailDTO(BillDetail billDetail){
        this.product = new ProductDTO(billDetail.getProduct());
        this.quantity = billDetail.getQuantity();
        this.discount = billDetail.getDiscount();
        this.orderPrice = billDetail.getOrderPrice();
    }

    public BillDetail convertToBillDetail(){
        return new BillDetail(this.product.convertToProduct(),this.quantity,this.discount,this.orderPrice);
    }

    public BillDetailDTO() {
    }
}

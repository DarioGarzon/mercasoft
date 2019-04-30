package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.domain.BillDetail;
import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.domain.User;

import javax.persistence.*;
import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Bill")
@NamedQueries({
        @NamedQuery(name = "BillDTO.findById",
                query = "SELECT c FROM BillDTO c WHERE c.id = : billId"),
}
)

public class BillDTO {

    private int id;
    private float totalValue;
    private List<BillDetailDTO> detailList;
    private UserDTO seller;
    private RegularCustomerDTO buyer;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    @OneToMany (
            cascade = CascadeType.ALL)
    public List<BillDetailDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BillDetailDTO> detailList) {
        this.detailList = detailList;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public UserDTO getSeller() {
        return seller;
    }

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public RegularCustomerDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(RegularCustomerDTO buyer) {
        this.buyer = buyer;
    }

    public BillDTO(float totalValue, List<BillDetailDTO> detailList, UserDTO seller, RegularCustomerDTO buyer) {
        this.totalValue = totalValue;
        this.detailList = detailList;
        this.seller = seller;
        this.buyer = buyer;
    }
    public BillDTO(Bill bill){
        this.totalValue = bill.getTotalValue();
        this.detailList= new ArrayList<>();
        for (BillDetail detail:bill.getDetailList()) {
            this.detailList.add(new BillDetailDTO(detail));
        }
        this.seller = new UserDTO(bill.getSeller());
        if(bill.getBuyer()!= null)
        {this.buyer = new RegularCustomerDTO(bill.getBuyer());}
    }
}

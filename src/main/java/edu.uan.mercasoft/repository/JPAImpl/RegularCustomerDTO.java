package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.NaturalPerson;
import edu.uan.mercasoft.domain.RegularCustomer;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;
@Entity
@Table(name = "Regular_Customer")
@NamedQueries({
        @NamedQuery(name = "RegularCustomerDTO.findBydocumentNumber", query = "SELECT c FROM RegularCustomerDTO c WHERE c.documentNumber = :documentNumber"),
}
)

public class RegularCustomerDTO extends NaturalPersonDTO {
    private Date subscriptionDate;
    private String phoneNumber;
    private short score;
    private String address;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RegularCustomerDTO(RegularCustomer customer) {
        this.subscriptionDate=customer.getSubscriptionDate();
        this.phoneNumber= customer.getPhoneNumber();
        this.score=customer.getScore();
        this.name=customer.getName();
        this.lastName=customer.getLastName();
        this.documentNumber=customer.getDocumentNumber();
        this.address=customer.getAddress();
    }

    public RegularCustomer convertToCustomer() {
        return new RegularCustomer(this.getSubscriptionDate(),
                this.phoneNumber, this.score,new NaturalPerson(this.name,this.lastName,this.documentNumber),this.address);
    }

    public RegularCustomerDTO() {
    }
}

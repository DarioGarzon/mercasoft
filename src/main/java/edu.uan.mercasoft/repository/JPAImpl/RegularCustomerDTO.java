package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.RegularCustomer;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "Regular_Customer")
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
    }
}

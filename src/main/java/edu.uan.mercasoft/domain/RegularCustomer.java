package edu.uan.mercasoft.domain;

import java.util.Date;

public class RegularCustomer  extends NaturalPerson {
    private Date subscriptionDate;
    private String phoneNumber;
    private short score;
    private String address;

    public RegularCustomer(String name, String lastName, String documentNumber,
                           Date subscriptionDate, String phoneNumber, short score,String address) {
        super(name, lastName, documentNumber);
        this.subscriptionDate = subscriptionDate;
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.address=address;
    }

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

    public RegularCustomer(Date subscriptionDate, String phoneNumber, short score, NaturalPerson person, String address) {
        super(person.name,person.lastName,person.documentNumber);
        this.subscriptionDate = subscriptionDate;
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.address=address;
    }


}

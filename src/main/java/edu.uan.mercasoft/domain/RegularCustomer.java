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

    public RegularCustomer(Date subscriptionDate, String phoneNumber, short score,NaturalPerson person,String address) {
        super(person.name,person.lastName,person.documentNumber);
        this.subscriptionDate = subscriptionDate;
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.address=address;
    }
}

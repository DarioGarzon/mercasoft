package edu.uan.mercasoft.domain;

public class Supplier {
    private String nit;
    private String name;
    private String phoneNumber;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Supplier(String nit, String name, String phoneNumber) {
        this.nit = nit;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

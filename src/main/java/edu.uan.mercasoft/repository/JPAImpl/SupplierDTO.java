package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Supplier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class SupplierDTO {
    public SupplierDTO() {
    }

    private String nit;
    private String name;
    private String phoneNumber;
    @Id
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

    public Supplier convertToSupplier() {
        return new Supplier(this.nit,this.name,this.phoneNumber);
    }

    public SupplierDTO(Supplier supplier) {
        this.nit=supplier.getNit();
        this.name=supplier.getName();
        this.phoneNumber=supplier.getPhoneNumber();
    }
}

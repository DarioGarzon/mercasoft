package edu.uan.mercasoft.domain;

import java.util.Date;

public class Product {
    private String productCode;
    private String name;
    private float price;
    private short appliedTax;
    private ProductType productType;
    private Date expirationDate;
    private String unitOfMeasure;
    private Supplier supplier;
    private int version;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public short getAppliedTax() {
        return appliedTax;
    }

    public void setAppliedTax(short appliedTax) {
        this.appliedTax = appliedTax;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product(String productCode, String name, float price, short appliedTax, ProductType productType, Date expirationDate, String unitOfMeasure, Supplier supplier, int version) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.appliedTax = appliedTax;
        this.productType = productType;
        this.expirationDate = expirationDate;
        this.unitOfMeasure = unitOfMeasure;
        this.supplier = supplier;
        this.version = version;
    }

}

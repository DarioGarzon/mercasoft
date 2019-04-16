package edu.uan.mercasoft.Model;

import java.util.Date;

public class Product {
    private String productCode;
    private String name;
    private float price;
    private short appliedTax;
    private ProductType productType;
    private Date exporationDate;
    private String unitOfMeasure;
    private Supplier supplier;

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
}

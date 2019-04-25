package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;
import edu.uan.mercasoft.domain.Supplier;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Product")
@NamedQueries({
        @NamedQuery(name = "ProductDTO.findByCode",
                query = "SELECT c FROM ProductDTO c WHERE c.productCode = :productCode ORDER BY c.version desc"),
        @NamedQuery(name = "ProductDTO.findByCodeContains",
                query = "SELECT c FROM UserDTO c WHERE c.userName like :productCode"),
}
)
public class ProductDTO {
    private int id;
    private String productCode;
    private String name;
    private float price;
    private short appliedTax;
    private ProductTypeDTO productType;
    private Date expirationDate;
    private String unitOfMeasure;
    private SupplierDTO supplier;
    private int version;

    public ProductDTO(Product product) {
        this.productCode =product.getProductCode();
        this.name =product.getName();
        this.price = product.getPrice();
        this.appliedTax =product.getAppliedTax();
        this.productType =new ProductTypeDTO(product.getProductType());
        this.expirationDate = product.getExpirationDate();
        this.unitOfMeasure = product.getUnitOfMeasure();
        this.supplier =new SupplierDTO(product.getSupplier());
        this.version = product.getVersion();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @ManyToOne(cascade = CascadeType.ALL)
    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
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
    @ManyToOne(cascade = CascadeType.ALL)
    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public ProductDTO() {
    }

    public Product convertToProduct() {
        return new Product(this.productCode,this.name,this.price,this.appliedTax,
                this.productType.convertToProductType(),this.expirationDate,this.unitOfMeasure,
                this.supplier.convertToSupplier(),this.version);
    }
}

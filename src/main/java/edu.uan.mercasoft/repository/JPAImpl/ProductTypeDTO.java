package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;

import javax.persistence.*;

@Entity
@Table(name = "Product_Type")
public class ProductTypeDTO {
    private int id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductTypeDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductTypeDTO(ProductType productType) {

        this.name = productType.getName();
        this.description = productType.getDescription();
    }
    public ProductType convertToProductType(){
        return new ProductType(this.name,this.description);
    }

    public ProductTypeDTO() {
    }
}

package edu.uan.mercasoft.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Permission")
public class PermissionDTO {

    private String name;
    private String description;
    @Id
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

    public PermissionDTO() {
    }

    public PermissionDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

package edu.uan.mercasoft.domain;

import edu.uan.mercasoft.repository.JPAImpl.PermissionDTO;

public class Permission {
    private String name;
    private String description;

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

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

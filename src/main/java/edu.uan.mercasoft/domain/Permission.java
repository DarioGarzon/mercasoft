package edu.uan.mercasoft.domain;

import edu.uan.mercasoft.repository.PermissionDTO;

public class Permission {
    private String name;
    private String description;

    public Permission(PermissionDTO permissionFromData){
        this.description=permissionFromData.getDescription();
        this.name=permissionFromData.getName();
    }
}

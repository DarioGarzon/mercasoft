package edu.uan.mercasoft.domain;

import edu.uan.mercasoft.repository.PermissionDTO;
import edu.uan.mercasoft.repository.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public class Role {

    private String name;
    private List<Permission> permissionList;

    public Role(RoleDTO role) {
        this.name=role.getName();
        this.permissionList= new ArrayList<Permission>();
        for (PermissionDTO permissionFromData:role.getPermissionList()) {
            this.permissionList.add(new Permission(permissionFromData));
        }
    }
}

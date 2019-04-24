package edu.uan.mercasoft.domain;

import edu.uan.mercasoft.repository.JPAImpl.PermissionDTO;
import edu.uan.mercasoft.repository.JPAImpl.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public class Role {

    private String name;
    private List<Permission> permissionList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name, List<Permission> permissionList) {
        this.name = name;
        this.permissionList = permissionList;
    }
}

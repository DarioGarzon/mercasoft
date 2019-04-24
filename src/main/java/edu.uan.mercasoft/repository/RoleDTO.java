package edu.uan.mercasoft.repository;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
public class RoleDTO {

    private String name;
    private List<PermissionDTO> permissionList;
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<PermissionDTO> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionDTO> permissionList) {
        this.permissionList = permissionList;
    }

    public RoleDTO() {
    }
}

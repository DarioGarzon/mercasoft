package edu.uan.mercasoft.repository.JPAImpl;
import edu.uan.mercasoft.domain.Permission;
import edu.uan.mercasoft.domain.Role;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Role_Permission",
            joinColumns = @JoinColumn(name = "role_name"),
            inverseJoinColumns = @JoinColumn(name = "permission_name"))
    public List<PermissionDTO> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionDTO> permissionList) {
        this.permissionList = permissionList;
    }

    public RoleDTO() {
    }

    public RoleDTO(String name, List<PermissionDTO> permissionList) {
        this.name = name;
        this.permissionList = permissionList;
    }

    public Role ConvertToRole() {
        List<Permission>permissionListToPass= new ArrayList<>();
        for (PermissionDTO permissionFromData:this.permissionList) {
            permissionListToPass.add(permissionFromData.ConvertToPermission());
        }
        return new Role(this.name,permissionListToPass );
    }

    public RoleDTO(Role role){
        List<PermissionDTO>permissionListToPass= new ArrayList<>();
        role.getPermissionList().forEach(permission -> permissionListToPass.add(new PermissionDTO(permission)));
        this.name=role.getName();
        this.permissionList=permissionListToPass;
    }
}

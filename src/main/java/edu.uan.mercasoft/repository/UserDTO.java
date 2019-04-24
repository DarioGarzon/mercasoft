package edu.uan.mercasoft.repository;

import javax.persistence.*;

@Entity
@Table(name = "UserList")
@NamedQueries({

        @NamedQuery(name = "User.findByUserName", query = "SELECT c FROM UserDTO c WHERE c.userName = :userName"),
        @NamedQuery(name = "User.findByUserNameContains", query = "SELECT c FROM UserDTO c WHERE c.userName like :userName"),
        @NamedQuery(name = "User.findById", query = "SELECT c FROM UserDTO c WHERE c.id = :id"),
        @NamedQuery(name = "User.findAll", query = "SELECT c FROM UserDTO c")
}
)
public class UserDTO extends NaturalPersonDTO {
    private String userName;
    private String password;

    private RoleDTO role;


    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public UserDTO() {
    }

    public UserDTO(String userName, String password, RoleDTO role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

}

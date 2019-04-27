package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "MercaSoft_User")
@NamedQueries({

        @NamedQuery(name = "UserDTO.findByUserName", query = "SELECT c FROM UserDTO c WHERE c.userName = :userName"),
        @NamedQuery(name = "UserDTO.findByUserNameContains", query = "SELECT c FROM UserDTO c WHERE c.userName like :userName"),
        @NamedQuery(name = "UserDTO.findById", query = "SELECT c FROM UserDTO c WHERE c.id = :id"),
        @NamedQuery(name = "UserDTO.findAll", query = "SELECT c FROM UserDTO c")
}
)
public class UserDTO extends NaturalPersonDTO {
    private String userName;
    private String password;
    private RoleDTO role;

    @Column(name = "userName",unique = true)
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

    @ManyToOne(cascade = CascadeType.MERGE)
    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public UserDTO() {
    }

    public UserDTO(User user){
        this.setName(user.getName());
        this.setLastName(user.getLastName());
        this.setDocumentNumber(user.getDocumentNumber());
        this.setPassword(user.getPassword());
        this.setUserName(user.getUserName());
        this.setRole(new RoleDTO(user.getRole()));
    }

    public UserDTO(String userName, String password, RoleDTO role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User ConvertToUser() {
        return new User(this.getUserName(),this.getLastName(),this.getDocumentNumber(),
                this.getUserName(),this.getPassword(),this.role.ConvertToRole());
    }

}

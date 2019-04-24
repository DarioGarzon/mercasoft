package edu.uan.mercasoft.domain;


public class User extends NaturalPerson {

    private String userName;
    private String password;
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String name, String lastName, String documentNumber, String userName, String password, Role role) {
        super(name, lastName, documentNumber);
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(String userName, String password, Role role, NaturalPerson person) {
        super(person.name,person.lastName,person.documentNumber);
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}

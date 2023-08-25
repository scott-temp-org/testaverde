package org.example.testaverde;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String admin_role;

    public User() {}
    public User(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getAdminRole() {
        return admin_role;
    }
}

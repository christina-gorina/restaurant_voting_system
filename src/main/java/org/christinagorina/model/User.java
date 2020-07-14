package org.christinagorina.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity{

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    public User() {

    }

    public User(Integer id, String name, String password) {
        super(id, name);
        this.email = email;
        this.password = password;
    }

/*    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                '}';
    }
}

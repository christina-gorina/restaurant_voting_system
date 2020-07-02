package org.christinagorina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity{

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    public User() {

    }

    public User(Integer id, String name) {
        super(id, name);
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

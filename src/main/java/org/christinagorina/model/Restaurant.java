package org.christinagorina.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity{
    public static final String GET_ALL = "Restaurant.getAll";

    public Restaurant() {

    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

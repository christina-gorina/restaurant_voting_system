package org.christinagorina.model;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity{
    public static final String GET_ALL = "Restaurant.getAll";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Dish> dishes;

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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}

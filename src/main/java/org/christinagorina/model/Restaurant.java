package org.christinagorina.model;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity{
    public static final String GET_ALL = "Restaurant.getAll";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Votes> votes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Dish> dishes;

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

    public Set<Votes> getVotes() {
        return votes;
    }

    public void setVotes(Set<Votes> votes) {
        this.votes = votes;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

}

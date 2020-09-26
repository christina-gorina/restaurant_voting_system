package org.christinagorina.to;

import org.christinagorina.model.Dish;

import java.time.LocalDate;
import java.util.Set;

public class RestaurantTo extends BaseTo {
    private Integer id;
    private String name;
    private Set<Dish> dishes;
    private Integer countOfVotes;
    private LocalDate date;

    public RestaurantTo(Integer id, String name, Set<Dish> dishes, LocalDate date, Integer countOfVotes) {
        super(id);
        this.name = name;
        this.dishes = dishes;
        this.date = date;
        this.countOfVotes = countOfVotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getVotes() {
        return countOfVotes;
    }

    public void setVotes(Integer votes) {
        this.countOfVotes = votes;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

package org.christinagorina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="restaurant", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Dish() {

    }

    public Dish(Integer id, String name, LocalDate date, int price, Restaurant restaurant) {
        super(id, name);
        this.date = date;
        this.price = price;
        this.restaurant = restaurant;
    }

    /*public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }*/

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name =" + name +
                ", price=" + price +
                ", date=" + date +
                ", restaurant=" + restaurant +
                '}';
    }
}

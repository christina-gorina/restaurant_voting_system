package org.christinagorina.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "date", nullable = false)
    public LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Restaurant restaurant;

    public Dish() {

    }

    public Dish(Integer id, String name, LocalDate date, int price) {
        super(id, name);
        this.date = date;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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

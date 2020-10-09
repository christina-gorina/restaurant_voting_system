package org.christinagorina.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant", "user"}, name = "user_restaurant_unique_vote_idx")})
public class Votes extends AbstractBaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")

    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant")

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Restaurant restaurant;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    public Votes (){

    }

    public Votes (Integer id, Restaurant restaurant, User user, LocalDateTime dateTime){
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.dateTime = dateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", dateTime=" + dateTime +
                '}';
    }
}

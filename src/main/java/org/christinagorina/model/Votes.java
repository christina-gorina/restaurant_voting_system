package org.christinagorina.model;

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
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant")
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
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
                /*", restaurant=" + restaurant +*/
                /*", user=" + user +*/
                ", dateTime=" + dateTime +
                '}';
    }


}

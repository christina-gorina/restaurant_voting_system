package org.christinagorina.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Votes extends AbstractBaseEntity{
    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    @NotNull
    private User user;

    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant")
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    public Votes (){

    }

    public Votes (Integer id, Restaurant restaurant, User user, LocalDateTime date_time){
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.dateTime = date_time;
    }

    /*public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }*/

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

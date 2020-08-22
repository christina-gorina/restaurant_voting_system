package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    public Restaurant get(int id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithVotesByDate(LocalDateTime fromDate, LocalDateTime toDate);

    Restaurant getWithDishesByDate(int id, LocalDate date);

    Restaurant getWithVotesByDate(int id, LocalDateTime fromDate, LocalDateTime toDate);

    Restaurant getWithDishesByDateAndVotesByDate(int id, LocalDate date, LocalDateTime fromDate, LocalDateTime toDate);
}

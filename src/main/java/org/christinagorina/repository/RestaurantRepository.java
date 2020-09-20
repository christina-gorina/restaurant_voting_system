package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    Set<Restaurant> getAllWithVotesByDate(LocalDateTime fromDate, LocalDateTime toDate);

    Set<Restaurant> getAllWithDishesByDate(LocalDate date);

    Restaurant getWithDishesByDate(int id, LocalDate date);

    Restaurant getWithVotesByDate(int id, LocalDateTime fromDate, LocalDateTime toDate);

    Restaurant getWithDishesByDateAndVotesByDate(int id, LocalDate date, LocalDateTime fromDate, LocalDateTime toDate);
}

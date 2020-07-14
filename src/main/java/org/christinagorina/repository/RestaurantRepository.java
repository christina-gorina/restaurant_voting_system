package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant getWithDishes(int id);

    List<Restaurant> getAll();

    public Restaurant get(int id);
}

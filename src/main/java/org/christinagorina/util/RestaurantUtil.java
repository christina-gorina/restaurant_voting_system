package org.christinagorina.util;

import org.christinagorina.model.Restaurant;
import org.christinagorina.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestaurantUtil {
    public static RestaurantTo getTo(Restaurant restaurant, LocalDate curDate) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getDishes(), curDate, restaurant.getVotes().size());
    }

    public static List<RestaurantTo> getListTo(Set<Restaurant> restaurants, LocalDate curDate) {
        return restaurants.stream().map(r->getTo(r, curDate)).collect(Collectors.toList());
    }
}

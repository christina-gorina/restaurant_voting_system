package org.christinagorina.util;

import org.christinagorina.model.Restaurant;
import org.christinagorina.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestaurantUtil {
    public static RestaurantTo getTo(Restaurant restaurant, LocalDate curDate) {
        System.out.println("getId = " + restaurant.getId());
        System.out.println("getTo = " + restaurant.getVotes().size());
        RestaurantTo r = new RestaurantTo(restaurant.getId(), restaurant.getName(), null, curDate, restaurant.getVotes().size());
        System.out.println("getTo r = " + r);
        return r;
    }

    public static List<RestaurantTo> getListTo(Set<Restaurant> restaurants, LocalDate curDate) {
        System.out.println("getListTo = " + restaurants);
        return restaurants.stream().map(r->getTo(r, curDate)).collect(Collectors.toList());
    }
}

package org.christinagorina;

import org.christinagorina.model.*;
import org.christinagorina.to.RestaurantTo;

import java.time.LocalDate;
import java.util.Set;

import static org.christinagorina.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsWithIgnoringAssertions(Restaurant.class, "dishes");
    public static TestMatcher<RestaurantTo> RESTAURANT_TO_MATCHER = TestMatcher.usingEqualsAssertions(RestaurantTo.class);

    public static final int RESTAURANT1_ID = START_SEQ + 11;
    public static final int RESTAURANT2_ID = START_SEQ + 12;
    public static final String CURRENT_DATE_STRING = "2020-07-05T21:00:00";

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "Итальянский ресторан");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT1_ID + 1, "Суши бар");
    public static final Restaurant RESTAURANT2_WITH_DISHES = new Restaurant(RESTAURANT1_ID + 1, "Суши бар");
    public static final Restaurant RESTAURANT3 = new Restaurant(RESTAURANT1_ID + 2, "Китайский ресторан");

    public static final Dish DISH2_1 = new Dish(START_SEQ + 8, "Суши с тунцом", LocalDate.of(2020, 7,5), 490);
    public static final Dish DISH2_2 = new Dish(START_SEQ + 7, "Роллы калифорния", LocalDate.of(2020, 7,5), 430);
    public static final Dish DISH2_3 = new Dish(START_SEQ + 10, "Сяке", LocalDate.of(2020, 7,5), 620);

    public static final  Set<Dish> DISHES2 = Set.of(DISH2_1, DISH2_2, DISH2_3);

    public static final Restaurant RESTAURANTS2_WITH_DISHES_BY_DATE =  getRestaurantWithDishes(RESTAURANT2_WITH_DISHES, DISHES2);

    public static final Set<Restaurant> RESTAURANTS = Set.of(RESTAURANT1, RESTAURANT2, RESTAURANT3);

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "Итальянский ресторан новый");
    }

    public static Restaurant getNew() {
        return new Restaurant(null, "Новый рестаран");
    }

    public static Restaurant getNewWithEmptyDesc() {
        return new Restaurant(null, " ");
    }


    public static Restaurant getRestaurantWithDishes(Restaurant restaurant, Set<Dish> dishes) {
        restaurant.setDishes(dishes);
        return restaurant;
    }
}

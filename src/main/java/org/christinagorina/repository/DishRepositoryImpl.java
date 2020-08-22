package org.christinagorina.repository;

import org.christinagorina.model.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository{
    private final CrudDishRepository crudDishRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DishRepositoryImpl(CrudDishRepository crudDishRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudDishRepository = crudDishRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && get(dish.getId(), restaurantId) == null) {
            return null;
        }
        dish.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return crudDishRepository.delete(id, restaurantId) != 0;
    }

    @Override
    public Dish get(int id, int restaurantId) {
        return crudDishRepository.findById(id)
                .filter(dish -> dish.getRestaurant().getId() == restaurantId)
                .orElse(null);
    }

    @Override
    public List<Dish> getByDateAndRestaurant(int restaurantId, LocalDate date) {
        return crudDishRepository.getByDateAndRestaurant(restaurantId, date);
    }
}


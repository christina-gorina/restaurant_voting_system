package org.christinagorina.repository;

import org.christinagorina.model.Dish;
import org.christinagorina.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private static final Sort SORT_BY_NAME = Sort.by("name");
    private final CrudRestaurantRepository crudRestaurantRepository;

    @PersistenceContext
    private EntityManager em;

    public RestaurantRepositoryImpl(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Restaurant getWithDishes(int id) {
        return crudRestaurantRepository.getWithMeals(id);
    }

    @Override
    public Restaurant get(@Param("id") int id){
        return crudRestaurantRepository.findById(id).orElse(null);

    }

    @Override
    public List<Restaurant> getAll(){
        return crudRestaurantRepository.findAll(SORT_BY_NAME);
    }
}

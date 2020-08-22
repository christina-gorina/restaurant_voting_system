package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private static final Sort SORT_BY_NAME = Sort.by("name");
    private final CrudRestaurantRepository crudRestaurantRepository;

    public RestaurantRepositoryImpl(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public List<Restaurant> getAll(){//
        return crudRestaurantRepository.findAll(SORT_BY_NAME);
    }

    @Override
    public Restaurant get(@Param("id") int id){ //
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant>  getAllWithVotesByDate(LocalDateTime fromDate, LocalDateTime toDate) {
        return crudRestaurantRepository.getAllWithVotesByDate(fromDate, toDate);
    }

    @Override
    public List<Restaurant> getAllWithDishesByDate(LocalDate date) {
        return crudRestaurantRepository.getAllWithDishesByDate(date);
    }

    @Override
    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }

    @Override
    public Restaurant save(Restaurant restaurant){
        return crudRestaurantRepository.save(restaurant);
    };

    @Override
    public Restaurant getWithDishesByDate(int id, LocalDate date) {
        return crudRestaurantRepository.getWithDishesByDate(id, date);
    }

    @Override
    public Restaurant getWithDishesByDateAndVotesByDate(int id, LocalDate date, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudRestaurantRepository.getWithDishesByDateAndVotesByDate(id, date, fromDate, toDate);
    }

    @Override
    public Restaurant getWithVotesByDate(int id, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudRestaurantRepository.getWithVotesByDate(id, fromDate, toDate);
    }

}



















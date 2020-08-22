package org.christinagorina.service;

import org.christinagorina.model.Restaurant;
import org.christinagorina.repository.RestaurantRepository;
import org.christinagorina.util.DateTimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.christinagorina.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public Restaurant get(int id){
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Restaurant> getAllWithVotesByDate(LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return repository.getAllWithVotesByDate(DateTimeUtil.atStartOfDay(date), DateTimeUtil.atStartOfNextDay(date));
    }

    public List<Restaurant> getAllWithDishesByDate(LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return repository.getAllWithDishesByDate(date);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), restaurant.id());
    }

    public Restaurant getWithDishesByDate(int id, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return checkNotFoundWithId(repository.getWithDishesByDate(id, date), id);
    }

    public Restaurant getWithDishesByDateAndVotesByDate(int id, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return checkNotFoundWithId(repository.getWithDishesByDateAndVotesByDate(id, date, DateTimeUtil.atStartOfDay(date), DateTimeUtil.atStartOfNextDay(date)), id);
    }

    public Restaurant getWithVotesByDate(int id, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        return checkNotFoundWithId(repository.getWithVotesByDate(id, DateTimeUtil.atStartOfDay(date), DateTimeUtil.atStartOfNextDay(date)), id);
    }

}





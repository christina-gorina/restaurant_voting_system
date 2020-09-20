package org.christinagorina.web;

import org.christinagorina.model.Restaurant;
import org.christinagorina.service.RestaurantService;
import org.christinagorina.to.RestaurantTo;
import org.christinagorina.util.RestaurantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.christinagorina.util.ValidationUtil.*;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String REST_URL = "/rest/restaurants";

    @Autowired
    private RestaurantService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        checkNew(restaurant);
        Restaurant created =  service.create(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        assureIdConsistent(restaurant, id);
        service.update(restaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/{id}/{curDate}/dishes")
    public Restaurant getWithDishesByDate(@PathVariable int id, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getWithDishesByDate(id, curDate.toLocalDate());
    }

    @GetMapping("/{id}/{curDate}/votes")
    public RestaurantTo getWithVotesByDate(@PathVariable int id, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        Restaurant restaurant = service.getWithVotesByDate(id, curDate.toLocalDate());
        return RestaurantUtil.getTo(restaurant, curDate.toLocalDate());
    }

    @GetMapping("/{id}/{curDate}/dishesandvotes")
    public RestaurantTo getWithDishesByDateAndVotesByDate(@PathVariable int id, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        Restaurant restaurant = service.getWithDishesByDateAndVotesByDate(id, curDate.toLocalDate());
        return RestaurantUtil.getTo(restaurant, curDate.toLocalDate());
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping("/{curDate}/dishes")
    public Set<Restaurant> getAllWithDishesByDate(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getAllWithDishesByDate(curDate.toLocalDate());
    }

    @GetMapping("/{curDate}/votes")
    public List<RestaurantTo> getAllWithVotesByDate(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        Set<Restaurant> restaurants = service.getAllWithVotesByDate(curDate.toLocalDate());
        return RestaurantUtil.getListTo(restaurants, curDate.toLocalDate());
    }
}

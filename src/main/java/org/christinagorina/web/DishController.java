package org.christinagorina.web;

import org.christinagorina.model.Dish;
import org.christinagorina.model.Restaurant;
import org.christinagorina.service.DishService;
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

import static org.christinagorina.util.ValidationUtil.assureIdConsistent;
import static org.christinagorina.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = DishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    static final String REST_URL = "/rest/dishes";

    @Autowired
    private DishService service;

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish, @PathVariable int restaurantId) {
        checkNew(dish);
        Dish created =  service.create(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{restaurantId}/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{restaurantId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int restaurantId, @PathVariable int id) {
        assureIdConsistent(dish, id);
        service.update(dish, restaurantId);
    }

    @DeleteMapping("/{restaurantId}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId, @PathVariable int id) {
        service.delete(id, restaurantId);
    }

    @GetMapping("/{restaurantId}/{id}")
    public Dish get(@PathVariable int restaurantId, @PathVariable int id) {
        return service.get(id, restaurantId);
    }

    @GetMapping("/{restaurantId}/date/{curDate}")
    public List<Dish> getAllByDateAndRestaurant(@PathVariable int restaurantId, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getByDateAndRestaurant(restaurantId, curDate.toLocalDate());
    }
}
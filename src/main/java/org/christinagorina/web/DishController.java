package org.christinagorina.web;

import org.christinagorina.model.Dish;
import org.christinagorina.service.DishService;
import org.christinagorina.util.ValidationUtil;
import org.christinagorina.util.exeption.IllegalRequestDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import static org.christinagorina.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    static final String REST_URL_ADMIN = "/rest/admin/dishes";
    static final String REST_URL_USER = "/rest/user/dishes";

    @Autowired
    private DishService service;

    @PostMapping(value = REST_URL_ADMIN + "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@Valid @RequestBody Dish dish, @PathVariable int restaurantId, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalRequestDataException(ValidationUtil.getErrorResponse(result));
        }
        Dish created =  service.create(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL_ADMIN + "/{restaurantId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = REST_URL_ADMIN + "/{restaurantId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int restaurantId, @PathVariable int id) {
        assureIdConsistent(dish, id);
        service.update(dish, restaurantId);
    }

    @DeleteMapping(REST_URL_ADMIN + "/{restaurantId}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId, @PathVariable int id) {
        service.delete(id, restaurantId);
    }

    @GetMapping(REST_URL_USER + "/{restaurantId}/{id}")
    public Dish get(@PathVariable int restaurantId, @PathVariable int id) {
        return service.get(id, restaurantId);
    }

    @GetMapping(REST_URL_USER + "/{restaurantId}/date/{curDate}")
    public List<Dish> getAllByDateAndRestaurant(@PathVariable int restaurantId, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getByDateAndRestaurant(restaurantId, curDate.toLocalDate());
    }
}

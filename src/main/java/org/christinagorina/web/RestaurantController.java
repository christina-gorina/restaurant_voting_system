package org.christinagorina.web;

import org.christinagorina.model.Restaurant;
import org.christinagorina.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String REST_URL = "/rest/restaurant";

    @Autowired
    private RestaurantService service;

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/{id}/{curDate}/dishes")
    public Restaurant getWithDishesByDate(@PathVariable int id, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getWithDishesByDate(id, curDate.toLocalDate());
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}/{curDate}/votes")
    public Restaurant getWithVotesByDate(@PathVariable int id, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getWithVotesByDate(id, curDate.toLocalDate());
    }
}

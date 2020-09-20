package org.christinagorina.web;

import org.christinagorina.model.Votes;
import org.christinagorina.service.VoteService;
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

import static org.christinagorina.util.ValidationUtil.assureIdConsistent;
import static org.christinagorina.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String REST_URL = "/rest/votes";

    @Autowired
    private VoteService service;

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Votes> createWithLocation(@RequestBody Votes vote, @PathVariable int restaurantId) {
        checkNew(vote);
        Votes created =  service.create(vote, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{restaurantId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Votes vote, @PathVariable int restaurantId, @PathVariable int id) {
        assureIdConsistent(vote, id);
        service.update(vote, restaurantId);
    }

    @GetMapping("/{restaurantId}/{id}")
    public Votes get(@PathVariable int restaurantId, @PathVariable int id) {
        return service.get(id, restaurantId);
    }

    @GetMapping("/{restaurantId}/date/{curDate}")
    public List<Votes> getByDateAndRestaurant(@PathVariable int restaurantId, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getByDateAndRestaurant(restaurantId, curDate.toLocalDate());
    }
}


















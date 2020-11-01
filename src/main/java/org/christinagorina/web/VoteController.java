package org.christinagorina.web;

import org.christinagorina.model.Votes;
import org.christinagorina.service.VoteService;
import org.christinagorina.util.DateTimeUtil;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.christinagorina.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = VoteController.REST_URL_USER, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String REST_URL_USER = "/rest/user/votes";

    @Autowired
    private VoteService service;
/*
    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Votes> createWithLocation(@Valid @RequestBody Votes vote, @PathVariable int restaurantId, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalRequestDataException(ValidationUtil.getErrorResponse(result));
        }
        int userId = SecurityUtil.authUserId();
        Votes created = service.create(vote, restaurantId, userId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL_USER + "/{restaurantId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
*/
    @PutMapping(value = "/{restaurantId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Votes vote, @PathVariable int restaurantId, @PathVariable int id) {
        int userId = SecurityUtil.authUserId();
        assureIdConsistent(vote, id);
        service.update(vote, restaurantId, userId);
    }

    @GetMapping("/{id}")
    public Votes get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/{restaurantId}/date/{curDate}")
    public List<Votes> getByDateAndRestaurant(@PathVariable int restaurantId, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        return service.getByDateAndRestaurant(restaurantId, curDate.toLocalDate());
    }

    @GetMapping("/date/{curDate}")
        public Votes getByUserAndDate(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime curDate) {
        int userId = SecurityUtil.authUserId();
        return service.getByUserAndDate(userId, curDate.toLocalDate());
    }

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Votes> createWithLocation(@Valid @RequestBody Votes vote, @PathVariable int restaurantId, BindingResult result) {
//TODO потестить
        if (result.hasErrors() || !DateTimeUtil.changeVote(LocalDateTime.now())) {
            throw new IllegalRequestDataException(ValidationUtil.getErrorResponse(result));
        }

        int userId = SecurityUtil.authUserId();

        Votes votes = service.getByUserAndDate(userId, LocalDate.now());
        if(votes != null){
            service.delete(votes.getId(), userId);
        }

        Votes created = service.create(vote, restaurantId, userId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL_USER + "/{restaurantId}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}


















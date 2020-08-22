package org.christinagorina.service;

import org.christinagorina.model.Votes;
import org.christinagorina.repository.VoteRepository;
import org.christinagorina.util.DateTimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static org.christinagorina.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Votes create(Votes vote, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        return repository.save(vote, restaurantId);
    }

    public void update(Votes vote, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote, restaurantId), vote.id());
    }

    public Votes get(int id, int restaurantId) {
        return checkNotFoundWithId(repository.get(id, restaurantId), id);
    }

    public List<Votes> getByDateAndRestaurant(int restaurantId, LocalDate date) {
        return repository.getByDateAndRestaurant(restaurantId, DateTimeUtil.atStartOfDay(date), DateTimeUtil.atStartOfNextDay(date));
    }
}

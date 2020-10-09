package org.christinagorina.repository;

import org.christinagorina.model.Votes;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository {
    Votes save(Votes vote, int restaurantId, int userId);

    List<Votes> getAllByDateAndRestaurant(int restaurantId, LocalDateTime fromDate, LocalDateTime toDate);

    Votes get(int id, int restaurantId);
}

package org.christinagorina.repository;

import org.christinagorina.model.Votes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository{
    private final CrudVoteRepository crudVoteRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;
    private final CrudUserRepository crudUserRepository;

    public VoteRepositoryImpl(CrudVoteRepository crudVoteRepository, CrudRestaurantRepository crudRestaurantRepository, CrudUserRepository crudUserRepository) {
        this.crudVoteRepository = crudVoteRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Votes save(Votes vote, int restaurantId, int userId) {
        if (!vote.isNew() && get(vote.getId(), restaurantId) == null) {
            return null;
        }
        vote.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        vote.setUser(crudUserRepository.getOne(userId));
        return crudVoteRepository.save(vote);
    }

    @Override
    public Votes get(int id, int restaurantId){
        return crudVoteRepository.findById(id)
                .filter(vote -> vote.getRestaurant().getId() == restaurantId)
                .orElse(null);
    };

    @Override
    public List<Votes> getAllByDateAndRestaurant(int restaurantId, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudVoteRepository.getByDateAndRestaurant(restaurantId, fromDate, toDate);
    }
}

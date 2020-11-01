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
        if (!vote.isNew() && get(vote.getId()) == null) {
            return null;
        }
        vote.setDateTime(LocalDateTime.now());
        vote.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        vote.setUser(crudUserRepository.getOne(userId));
        return crudVoteRepository.save(vote);
    }

    @Override
    public Votes get(int id){
        return crudVoteRepository.findById(id).orElse(null);
    };

    @Override
    public List<Votes> getAllByDateAndRestaurant(int restaurantId, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudVoteRepository.getByDateAndRestaurant(restaurantId, fromDate, toDate);
    }

    @Override
    public Votes getByUserAndDate(int userId, LocalDateTime fromDate, LocalDateTime toDate) {
        return crudVoteRepository.getByUserAndDate(userId, fromDate, toDate);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudVoteRepository.delete(id, userId) != 0;
    }
}

package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=?1")
    int delete(int id);

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.votes vote WHERE vote.dateTime >=?1 AND vote.dateTime <?2 ORDER BY r.name DESC")
    Set<Restaurant> getAllWithVotesByDate(LocalDateTime fromDate, LocalDateTime toDate);

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.dishes dish WHERE dish.date =?1 ORDER BY r.id ASC")
    Set<Restaurant> getAllWithDishesByDate(LocalDate date);

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.dishes dish WHERE r.id=?1 AND dish.date=?2 ORDER BY r.name DESC")
    Restaurant getWithDishesByDate(int id, LocalDate date);

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.votes vote WHERE r.id=?1 AND vote.dateTime >=?2 AND vote.dateTime <?3 ")
    Restaurant getWithVotesByDate(int id, LocalDateTime fromDate, LocalDateTime toDate);

   @Query("SELECT r FROM Restaurant r JOIN FETCH r.dishes dish JOIN FETCH r.votes vote WHERE r.id=?1 AND dish.date =?2 AND vote.dateTime >=?3 AND vote.dateTime <?4  ORDER BY r.name DESC")
    Restaurant getWithDishesByDateAndVotesByDate(int id, LocalDate date, LocalDateTime fromDate, LocalDateTime toDate);
}






















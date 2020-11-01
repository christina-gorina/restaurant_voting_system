package org.christinagorina.repository;

import org.christinagorina.model.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Votes, Integer> {

    @Query("SELECT v FROM Votes v WHERE v.restaurant.id =:restaurantId AND v.dateTime >=:fromDate AND v.dateTime <:toDate")
    List<Votes> getByDateAndRestaurant(@Param("restaurantId") int restaurantId, @Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);

    @Modifying
    @Transactional
    @Query("DELETE FROM Votes v WHERE v.id =:id AND v.user =:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Votes v WHERE v.user.id =:userId AND v.dateTime >=:fromDate AND v.dateTime <:toDate")
    Votes getByUserAndDate(@Param("userId") int userId, @Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);


}

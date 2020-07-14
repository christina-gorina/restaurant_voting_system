package org.christinagorina.repository;

import org.christinagorina.model.Restaurant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    //@EntityGraph(attributePaths = {"dishes"})
    @Query("SELECT r FROM Restaurant r JOIN FETCH r.dishes WHERE r.id=?1")
    Restaurant getWithMeals(int id);


}

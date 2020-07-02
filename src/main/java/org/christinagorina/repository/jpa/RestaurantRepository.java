package org.christinagorina.repository.jpa;

import org.christinagorina.model.Restaurant;
import org.christinagorina.repository.RestaurantRepositoryInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RestaurantRepository implements RestaurantRepositoryInterface {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> getAll(){
        return em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).getResultList();
    }

}

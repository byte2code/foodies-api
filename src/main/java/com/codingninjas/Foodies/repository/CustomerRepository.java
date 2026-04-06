package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByVisitedRestaurants(Restaurant restaurant); // JPA derived query

    @Query("SELECT DISTINCT c FROM Customer c JOIN c.ratings r WHERE r.restaurant.name = :restaurantName AND r.rating > :rating")
    List<Customer> findByVisitedRestaurantAndRatingGreaterThan(
	    @Param("restaurantName") String restaurantName,
	    @Param("rating") double rating);
}

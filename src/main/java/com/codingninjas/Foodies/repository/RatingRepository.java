package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "SELECT AVG(r.rating) FROM rating r JOIN restaurant res ON r.restaurant_id = res.id WHERE res.name = :restaurantName", nativeQuery = true)
    Double findAverageRatingByRestaurantName(@Param("restaurantName") String restaurantName);
}

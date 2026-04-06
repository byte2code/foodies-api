package com.codingninjas.Foodies.repository;

import com.codingninjas.Foodies.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    // Derived query method to find restaurant by name
    Restaurant findByName(String restaurantName);
}

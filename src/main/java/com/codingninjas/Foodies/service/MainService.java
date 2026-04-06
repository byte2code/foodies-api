package com.codingninjas.Foodies.service;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public Restaurant addRestaurant(Restaurant restaurant) {
	return restaurantRepository.save(restaurant);
    }

    public Customer addCustomer(Customer customer) {
	return customerRepository.save(customer);
    }

    public Rating addRating(Integer customerId, String restaurantName, Rating rating) {
	Customer customer = customerRepository.findById(customerId)
		.orElseThrow(() -> new RuntimeException("Customer not found"));

	Restaurant restaurant = restaurantRepository.findByName(restaurantName);
	if (restaurant == null) {
	    throw new RuntimeException("Restaurant not found");
	}

	// Set relationships
	rating.setCustomer(customer);
	rating.setRestaurant(restaurant);

	// Add rating to customer and restaurant lists
	customer.getRatings().add(rating);
	restaurant.getRatings().add(rating);

	// Add restaurant to customer's visited list if not already present
	if (!customer.getVisitedRestaurants().contains(restaurant)) {
	    customer.getVisitedRestaurants().add(restaurant);
	}

	// Save rating explicitly
	ratingRepository.save(rating);

	// Save customer and restaurant to update relationships
	customerRepository.save(customer);
	restaurantRepository.save(restaurant);

	return rating;
    }

    public List<Rating> getAllRatings() {
	return ratingRepository.findAll();
    }

    public List<Customer> getAllCustomers() {
	return customerRepository.findAll();
    }
}

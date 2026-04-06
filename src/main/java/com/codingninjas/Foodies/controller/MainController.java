package com.codingninjas.Foodies.controller;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping(value = "/Restaurant/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
	return ResponseEntity.ok(mainService.addRestaurant(restaurant));
    }

    @PostMapping(value = "/Customer/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	return ResponseEntity.ok(mainService.addCustomer(customer));
    }

    @PostMapping(value = "/Rating/{customerId}/add/{restaurantName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating, @PathVariable Integer customerId,
	    @PathVariable String restaurantName) {
	return ResponseEntity.ok(mainService.addRating(customerId, restaurantName, rating));
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
	return ResponseEntity.ok(mainService.getAllRatings());
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
	return ResponseEntity.ok(mainService.getAllCustomers());
    }
}

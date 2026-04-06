package com.codingninjas.Foodies.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "customer-ratings")
    private List<Rating> ratings = new ArrayList<>();

    @ManyToMany
    @JsonIgnore  // Optional: only if you don’t want full visited restaurants returned
    private List<Restaurant> visitedRestaurants = new ArrayList<>();


    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Rating> getRatings() {
	return ratings;
    }

    public void setRatings(List<Rating> ratings) {
	this.ratings = ratings;
    }

    public List<Restaurant> getVisitedRestaurants() {
	return visitedRestaurants;
    }

    public void setVisitedRestaurants(List<Restaurant> visitedRestaurants) {
	this.visitedRestaurants = visitedRestaurants;
    }

    // getters and setters

}

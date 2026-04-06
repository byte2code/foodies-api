# Foodies API

Spring Boot REST API for managing restaurants, customers, and ratings with JPA, H2 persistence, derived-query, JPQL, and native-query lookups.

## Overview

This project demonstrates a compact Spring Boot API for a food-review style workflow. It models customers, restaurants, and ratings, and shows how entity relationships can be updated together when a customer rates a restaurant and builds a visited-restaurants history. This version extends the project with restaurant average-rating lookup so the API now covers both relationship-driven writes and query-driven restaurant insights.

## Concepts and Features Covered

- Spring Boot REST API setup
- Spring Data JPA repository pattern
- H2 in-memory database integration
- One-to-many relationship from customer to ratings
- One-to-many relationship from restaurant to ratings
- Many-to-many relationship between customers and visited restaurants
- `POST` endpoint for creating restaurants
- `POST` endpoint for creating customers
- `POST` endpoint for adding a rating for a restaurant by a customer
- `GET` endpoint for retrieving all ratings
- `GET` endpoint for retrieving all customers
- Derived query for retrieving customers who visited a given restaurant
- JPQL query for retrieving customers by restaurant name and minimum rating
- Native query for calculating average rating by restaurant name
- `GET` endpoint for retrieving average rating for a restaurant
- Bidirectional relationship handling with JSON serialization controls

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5

## How to Run

1. Open a terminal in the project root.
2. Run `mvn test`.
3. Run `mvn spring-boot:run`.
4. Use the API under `http://localhost:8080`.

Available endpoints:

- `POST /Restaurant/add`
- `POST /Customer/add`
- `POST /Rating/{customerId}/add/{restaurantName}`
- `GET /ratings`
- `GET /customers`
- `GET /customers/restaurant/{restaurantName}`
- `GET /customers/restaurant/{restaurantName}/{rating}`
- `GET /restaurant/{restaurantName}/average`

Example request body for creating a restaurant:

```json
{
  "name": "Spice Garden"
}
```

Example request body for creating a customer:

```json
{
  "name": "Rohan"
}
```

Example request body for adding a rating:

```json
{
  "rating": 4.5
}
```

## Learning Highlights

- Demonstrates how to manage multiple related entities in a single service flow
- Shows relationship updates across customers, restaurants, and ratings
- Combines derived-query, JPQL, and native-query examples in one compact API
- Adds aggregate-style average-rating lookup for restaurant-level insight
- Keeps persistence in H2 so the project is easy to run and explore locally

## GitHub Metadata

- Suggested repository description: `Spring Boot REST API for managing restaurants, customers, and ratings with JPA, H2 persistence, plus derived-query, JPQL, and native-query lookups.`
- Suggested topics: `java`, `java-17`, `spring-boot`, `spring-data-jpa`, `h2-database`, `rest-api`, `foodies`, `restaurant-ratings`, `derived-query`, `jpql`, `native-query`, `maven`, `learning-project`, `portfolio-project`

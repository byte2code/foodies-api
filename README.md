# Foodies API

Spring Boot REST API for managing restaurants, customers, and ratings with JPA, H2 persistence, derived-query and JPQL lookups, and relationship-focused service design.

## Overview

This project demonstrates a compact Spring Boot API for a food-review style workflow. It models customers, restaurants, and ratings, and shows how entity relationships can be updated together when a customer rates a restaurant and builds a visited-restaurants history. This version also adds both derived-query and JPQL-based customer lookup options for restaurant-specific discovery.

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
- `GET` endpoint for retrieving customers by restaurant name
- JPQL query for retrieving customers who rated a restaurant above a threshold
- `GET` endpoint for retrieving customers by restaurant name and minimum rating
- Bidirectional relationship handling with JSON serialization controls

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5

## Project Structure

```text
foodies-api/
├── CHANGELOG.md
├── README.md
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src/
    ├── main/
    │   ├── java/com/codingninjas/Foodies/
    │   │   ├── controller/
    │   │   ├── entity/
    │   │   ├── repository/
    │   │   ├── service/
    │   │   └── FoodiesApplication.java
    │   └── resources/
    │       └── application.yml
    └── test/
```

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
- Introduces a practical derived-query example for many-to-many based lookup
- Adds a JPQL-based filtering query for restaurant-specific customer rating analysis
- Uses JSON reference annotations to avoid recursive serialization issues
- Keeps persistence in H2 so the project is easy to run and explore locally

## GitHub Metadata

- Suggested repository description: `Spring Boot REST API for managing restaurants, customers, and ratings with JPA, H2 persistence, plus derived-query and JPQL-based customer restaurant lookups.`
- Suggested topics: `java`, `java-17`, `spring-boot`, `spring-data-jpa`, `h2-database`, `rest-api`, `foodies`, `restaurant-ratings`, `derived-query`, `jpql`, `maven`, `learning-project`, `portfolio-project`

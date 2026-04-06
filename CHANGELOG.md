# Changelog

All notable changes to this project are documented in this file.

## [v3.0.0] - 2026-04-07

### Summary
Third version of the Foodies API that expands the project with restaurant-and-rating filtered customer lookup using JPQL.

### Highlights

- Added `GET /customers/restaurant/{restaurantName}/{rating}` to fetch customers who rated a restaurant above a given threshold.
- Added a JPQL query in `CustomerRepository` for filtering customers by restaurant name and rating.
- Added `findByVisitedRestaurantAndRatingGreaterThan(...)` in the service layer.
- Kept the existing customer-by-restaurant derived query and rating workflow intact.
- Refreshed the README to present the project as a stronger query-and-relationship showcase.

### Notes

This version improves the project’s learning value by combining derived-query and JPQL filtering in the same relationship-driven REST API.

## [v2.0.0] - 2026-04-06

### Summary
Second version of the Foodies API that expands the project with customer lookup by visited restaurant.

### Highlights

- Added `GET /customers/restaurant/{restaurantName}` to fetch customers who visited a specific restaurant.
- Added a derived query in `CustomerRepository` using `findByVisitedRestaurants(...)`.
- Updated the rating flow to build restaurant-visit history through the customer aggregate.
- Simplified controller responses while keeping the overall API flow intact.
- Refreshed the README to position the project as a stronger relationship-query learning showcase.

### Notes

This version improves the project’s learning value by combining relationship updates with a practical Spring Data JPA derived-query use case.

## [v1.0.0] - 2026-04-06

### Summary
Initial publication of the Foodies API as a clean, portfolio-ready Spring Boot REST project.

### Highlights

- Added a recruiter-friendly README with API overview, features, run steps, and project structure.
- Added a changelog for future version tracking.
- Cleaned IDE files, build artifacts, and system clutter before publishing.
- Preserved the original restaurant, customer, and rating relationship workflow built on Spring Data JPA and H2.

### Notes

This version establishes the project as a compact learning showcase for relationship-driven REST design with Spring Boot.

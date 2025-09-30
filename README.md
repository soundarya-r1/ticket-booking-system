# Ticket Booking System (BookMyShow Clone)

A simple **Spring Boot REST API** for managing users, events, and bookings.
This is the **initial version** of the project (v1), forming the foundation for a ticket booking application.

---

## Overview

This project provides APIs to:

* Manage **Users**
* Manage **Events**
* Manage **Bookings** (a user can book an event)

The goal is to simulate a minimal **BookMyShow**-like system.

---

## Tech Stack

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **H2 in-memory database** (default, for dev/testing)
* **Lombok**
* **Maven**

---

## Features (Initial Version)

* CRUD operations for:

  * **Users**
  * **Events**
  * **Bookings**
* In-memory H2 database for quick setup
* Layered architecture:

  * Controllers → Services → Repositories → Entities
* Global exception handler (skeleton present)

---

## Future Enhancements (Planned for Next Release)

* Use DTOs + request validation
* Hash passwords & add authentication
* Add transaction management for booking flow
* Add Swagger/OpenAPI documentation
* Add unit and integration tests

---

## Getting Started

### Prerequisites

* Java 17+
* Maven 3.6+
* IDE (IntelliJ / Eclipse / VS Code)

### Running the app

Clone the repo and run:

```bash
mvn clean package
mvn spring-boot:run
```

Or run the `BookMyShowApplication` class directly from your IDE.

The application runs on `http://localhost:8080`.

H2 console (if enabled):
`http://localhost:8080/h2-console`

* JDBC URL: `jdbc:h2:mem:Ticket`

---

## Project Structure

```
src/main/java/com/event/BookMyShow
  ├─ controller/      # REST controllers
  ├─ service/         # service interfaces
  ├─ service/impl     # service implementations
  ├─ repository/      # JPA repositories
  ├─ entity/          # JPA entities
  └─ exception/       # exception handling

src/main/resources
  ├─ application.properties
  └─ data.sql (sample data, optional)
```

---

## API Endpoints (basic)

### Users

* `GET /users` – Get all users
* `POST /users` – Create user
* `GET /users/{id}` – Get user by id
* `PUT /users/{id}` – Update user
* `DELETE /users/{id}` – Delete user

### Events

* `GET /events` – Get all events
* `POST /events` – Create event
* `GET /events/{id}` – Get event by id
* `PUT /events/{id}` – Update event
* `DELETE /events/{id}` – Delete event

### Bookings

* `GET /bookings` – Get all bookings
* `POST /bookings` – Create booking (user books an event)
* `GET /bookings/{id}` – Get booking by id
* `PUT /bookings/{id}` – Update booking
* `DELETE /bookings/{id}` – Cancel booking

---

## License

This project is open-source and free to use for learning.

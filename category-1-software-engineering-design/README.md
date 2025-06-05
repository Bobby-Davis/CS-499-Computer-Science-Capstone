# CS-499 Capstone - Category 1: Software Engineering and Design

This section of the capstone focuses on **Software Engineering and Design** by transforming a basic Java console application into a full-stack web application with a modern architecture using **Spring Boot**, **Angular**, and **MongoDB**.

## Original Program

The original program was a **Java-based console application** for managing rescue animals. It allowed users to:

- Add new dogs or monkeys to separate lists
- Reserve animals for service
- Print lists of available animals

This version used simple `ArrayList` structures, relied on console input/output, and lacked persistence, Modular structure, and separation of concerns. 

---

## Enhancements for Software Engineering and Design

To meet modern software engineering standards, I restructure the project using:

### Spring Boot (Backend)

- Rebuilt the backend using **Spring Boot**, applying the **MVC design pattern**:
    -**Model**: A unified `Animal` class instead of separate Dog and Monkey classes
    -**Service**: A dedicated `AnimalService` class for business logic
    -**Contoller**: RESTful API endpoints via `AnimalController`
- Integrated **MongoDB** for persistent, cloud-based data storage
- Implemented **CRUD operations** for managing animals
- Applied **input validation** and secure coding practices
- Set up **JWT authentication** for admin-only operations

### Angular (Frontend)
- Created an Angular frontend to replace the console interface
- Built components for viewing, adding, updating, and deleting animals
- Used conditional logic to handle animal type-specific fields
- Implemented a responsive UI that interacts with the backend APIs

---

## Software Design Principles 

- **Separation of Concerns** Through Spring Boot's layered architecture
- **Modularization** of backend logic into distinct service, controller, and model layers
- **Scalability** via a flexible, unified data model
- **Maintainability** using structured REST API endpoints and reusable Angular components
- **Security** through token-based authentication (JWT) and protected endpoints

---

## Technologies Used

- **Java** with **Spring Boot** (Backend API)
- **MongoDB** (Database)
- **Angular** (Frontend)
- **JWT Authentication** (Security)

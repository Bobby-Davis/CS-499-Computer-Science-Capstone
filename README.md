# CS-499 Computer Science Capstone: Full-Stack Rescue Animal Management System

This project is the final capstone for the Bachelor of Science in Computer Science program at Southern New Hampshire University. It showcases my ability to design, enhance, and deliver a complete software solution that reflects real-world standards in software engineering, algorithm development, and database integration.

The capstone project transforms an original Java-based console application, developed in IT-145, into a modern full-stack web application. The enhanced version is built using **Angular** for the frontend, **Spring Boot** for the backend API, and **MongoDB** as the database. The application allows users to view, manage, and filter records for rescue animals like dogs and monkeys, with secure admin-only functionality for creating, updating, and deleting records.

Each enhancement aligns with a specific area of the computer science program outcomes, broken down into three categories:

---

## Category 1: Software Engineering and Design

**Folder:** `category-1-software-engineering-design`

This enhancement focuses on refactoring the original console-based Java application into a structured, layered web application. It introduces a RESTful API using Spring Boot, a responsive frontend using Angular, and login functionality using JWT and BCrypt. The software follows the Model-View-Controller (MVC) pattern, demonstrates modular code organization, and includes role-based functionality for admin users.

[View README for Category 1](./category-1-software-engineering-design/README.md)

---

## Category 2: Algorithms and Data Structures

**Folder:** `category-2-algorithms-and-data-structures`

This enhancement improves the efficiency of data handling by implementing backend filtering, sorting, and pagination logic using MongoDB queries. It replaces in-memory `for` loop filtering with optimized query building and indexing, significantly improving time complexity from O(n) to O(log n) for common operations. Sorting and pagination are also handled server-side to reduce frontend processing.

[View README for Category 2](./category-2-algorithms-and-data-structures/README.md)

---

## Category 3: Databases

**Folder:** `category-3-databases`

This enhancement focuses on transforming the application's data storage layer by integrating MongoDB to replace temporary `ArrayList` memory structures. Animal data is now stored persistently using MongoDB collections, and CRUD operations are performed using Spring Data MongoDB repositories. Input validation is enforced before data is saved, and a unified data model was created to simplify record management.

[View README for Category 3](./category-3-databases/README.md)

---

## Security and Best Practices

Throughout the application, security and data integrity are key focuses. The backend uses:
- JWT-based authentication
- Encrypted password storage with BCrypt
- Input validation using Spring annotations
- Role-based access control for admin-only features

---

## Technologies Used

- **Frontend**: Angular
- **Backend**: Spring Boot (Java)
- **Database**: MongoDB
- **Authentication**: JWT, BCrypt
- **Tools**: Visual Studio Code, Postman, Git, GitHub

---

## Capstone Outcomes Demonstrated

- Design and development of professional-quality software systems
- Implementation of efficient algorithms and query structures
- Use of secure, scalable database solutions
- Application of software engineering principles including MVC, REST APIs, and modular design
- Incorporation of validation and security practices across the stack

---

## Summary

This project demonstrates my ability to evolve a basic Java console application into a full-featured, database-driven web application. It showcases my growth in software development, problem-solving, secure coding, and real-world application design. I am proud to present this work as the culmination of my undergraduate studies in computer science.

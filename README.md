# CS-499 Computer Science Capstone: Full-Stack Rescue Animal Management System

This project is the final capstone for the Bachelor of Science in Computer Science program at Southern New Hampshire University. It showcases my ability to design, enhance, and deliver a complete software solution that reflects real-world standards in software engineering, algorithm development, and database integration.

The capstone project transforms an original Java-based console application, developed in IT-145, into a modern full-stack web application. The enhanced version is built using **Angular** for the frontend, **Spring Boot** for the backend API, and **MongoDB** as the database. The application allows users to view, manage, and filter records for rescue animals like dogs and monkeys, with secure admin-only functionality for creating, updating, and deleting records.

Each enhancement aligns with a specific area of the computer science program outcomes, broken down into three categories:

---

## Code Review 

A code review is a structured process where developers review and evaluate source code to ensure it meets coding standards, design principles, and best practices. The goal of a code review is to:
- Identify bugs, logic errors, or security vulnerabilities early in development
- Ensure the code is clean, readable, and maintainable for future developers
- Verify that the code follows proper design patterns and architectural principles
- Share knowledge among team members and promote continuous learning

Code reviews help improve overall code quality, reduce long-term maintenance costs, and create more reliable, secure, and scalable software systems. 

The Code review video provides an in-depth walkthrough of the original Java console application, and the enhancements applied throughout the project. The video highlights improvements made across software engineering, algorithms and data structures, and database integration

You can watch the full code review video here:
[Watch Code Review Video](https://www.youtube.com/watch?v=lfZujDgJ_nw)

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

## Enhancement Narratives and Documentation

Each enhancement in this capstone project is supported by a detailed narrative that explains the motivation, implementation, and results of the improvements made in the areas of software design, algorithms and data structures, and database integration. These narratives reflect how the project aligns with key computer science course outcomes and provide insight into my problem-solving process and development decisions.

You can read the full enhancement narratives here:
- [Software Design and Engineering Narrative](./category-1-software-engineering-design/Software%20Design%20and%20Engineering%20Narrative.md)
- [Algorithms and Data Structures](./category-2-algorithms-and-data-structures/Algorithms%20and%20Data%20Structures%20Narrative.md)
- [Databases](./category-3-databases/Databases%20Narrative.md)

You can also view the complete source code for both versions of the project:
- [Original Java Console-Based Application](./original-artifact-rescue-animal-app)
- [Enhanced Full-Stack Web Application](./enhanced-rescue-animal-app)

To view the live ePortfolio site that showcases this capstone project, visit:  
- [My ePortfolio](https://your-username.github.io/)


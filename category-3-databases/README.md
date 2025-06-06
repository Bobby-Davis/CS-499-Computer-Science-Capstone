# CS-499 Capstone - Category 3: Databases

This section of the capstone focuses on Databases by enhancing how animal records are stored, retrieved, and updated in the Rescue Animal Management System. The original application relied on in-memory storage using Java `ArrayList`s, which meant data was lost after every session. This enhancement introduces a persistent data layer using MongoDB, allowing animal records to be saved permanently and efficiently accessed by users through backend APIs. By using Spring Data MongoDB, the application now supports full CRUD operations, scalable data handling, and secure input validation.

## Original Program Description

The original Rescue Animal Management System was a Java console application created during the IT-145 course. It allowed users to manage rescue animals — including dogs and monkeys — using command-line prompts. The data was stored in memory using `ArrayList`s, with separate lists for each type of animal and for available animals. Operations such as adding or reserving animals involved looping through these lists manually. Because there was no database or external file system, all animal data was lost once the program ended.

This design was useful for learning programming fundamentals, but not practical for real-world use. It lacked persistence, scalability, and data integrity. Each time the app restarted, users had to re-enter all data. There was also no protection against bad inputs or invalid data being stored.

## Overview of Enhancement

To make the system practical and scalable, I replaced the in-memory storage with a proper backend database. The enhanced version uses **MongoDB**, a NoSQL database that stores animal records as flexible, document-based collections. Using **Spring Data MongoDB**, I connected the backend to the database and created a full set of CRUD operations for managing animal records.

A new unified `Animal` model was introduced to replace the old separated lists for dogs and monkeys. This model is mapped to a MongoDB collection and includes key fields such as name, type, training status, reserved status, and age. The backend now interacts with MongoDB using repository interfaces, making it easy to add, retrieve, update, or delete records.

Input validation is also handled before any data is saved to MongoDB. This ensures that records are complete, correctly formatted, and consistent. For example, fields like `name` and `type` are validated using annotations such as `@NotBlank` and `@Size`. This prevents incomplete or invalid data from being stored.

## Enhancements Performed

### MongoDB Integration
- Replaced all in-memory `ArrayList` storage with MongoDB collections
- Used Spring Data MongoDB and `@Document` annotations to map Java objects to documents
- Implemented full CRUD operations for animal records using repository interfaces

### Unified Data Model
- Created a single `Animal` model to represent all animals (dogs, monkeys, etc.)
- Simplified data handling by removing the need for separate dog and monkey lists
- Included new fields like `type`, `reserved`, `trainingStatus`, and `age` to support filtering and sorting

### Data Persistence
- All animal records are now stored permanently and persist across sessions
- Users can access, modify, or remove records without losing data on app restart

### Input Validation
- Used Spring Boot validation annotations (`@NotBlank`, `@Size`, etc.) to ensure data quality
- Added validation logic in backend controllers to prevent incomplete or incorrect records from being saved

### Query Optimization
- Backend supports efficient retrieval using custom queries and indexed fields
- Filtering and sorting logic is offloaded to the database for better performance

## Skills Demonstrated

- Designing a data model using Spring Data MongoDB
- Creating and interacting with persistent collections in a NoSQL database
- Structuring backend repositories for scalable CRUD operations
- Validating input before saving it to a database to ensure data integrity
- Unifying application data into a clean, flexible schema

## Related Capstone Outcome(s)

- **Outcome 3**: Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices
- **Outcome 4**: Use well-founded and innovative techniques and tools in computing practices to implement solutions that deliver value
- **Outcome 5**: Develop a security mindset to protect data integrity and ensure clean, validated inputs

## Summary

This enhancement transforms the Rescue Animal Management System from a temporary, in-memory console app into a persistent, database-driven web application. By integrating MongoDB and applying input validation, the application now supports real-world usage where data must be retained, secured, and accessed efficiently. This work reflects my ability to build scalable, maintainable systems using professional-grade database technologies and backend development techniques.

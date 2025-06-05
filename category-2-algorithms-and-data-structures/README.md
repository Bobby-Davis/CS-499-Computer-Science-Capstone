# CS-499 Capstone - Category 2: Algorithms and Data Structures

This section of the capstone focuses on **Algorithms and Data Structures** by enhancing how data is searched, sorted, and retrieved within the Rescue Animal Management System. The goal is to apply algorithmic thinking and data handling techniques that optimize system performance, particularly in filtering, sorting, and pagination of animal records. By offloading data operations to the backend and using efficient query patterns in MongoDB, the application becomes more scalable and responsive.


## Original Program Description

The original Rescue Animal Management System was created as a Java console application in the IT-145 course. It allowed users to manage two types of animals — dogs and monkeys — using command-line input. Animal records were stored in `ArrayList` collections, and operations such as searching, filtering, and listing animals were performed using `for` loops and conditional logic. For example, to find available animals with a specific training status, the program would loop through the entire list and check each record manually.

While this approach was functional for small datasets, it did not scale well. The time complexity for search and filter operations was **O(n)** — meaning that as the number of animals increased, performance decreased linearly. There was no support for sorting or pagination, and filtering by multiple fields required nested `if` statements and multiple passes over the data. In addition, data was not persistent; all records were lost once the program closed.

---

## Overview of Enhancement

To improve performance and scalability, the application was enhanced using algorithmic principles and MongoDB’s native indexing and querying capabilities. This enhancement focused specifically on how animal data is filtered, sorted, and paginated — replacing inefficient in-memory operations with optimized backend logic.

Instead of performing linear scans in Java, the new system constructs queries in the backend that MongoDB can resolve efficiently, often in **O(log n)** time when indexed. These enhancements significantly reduce the computational burden, improve the user experience, and allow the system to scale with larger datasets.

---

## Enhancements Performed

### Filtering
Users can now filter animals based on:
- Animal type (Dog or Monkey)
- Size (Small, Medium, Large)
- Age range
- Availability (reserved status and training status = "in service")

Instead of checking each item manually as in the original version, the backend now constructs a MongoDB query object based on user-selected filters and retrieves only the relevant results. This offloads the logic from the Angular frontend and increases backend efficiency.

###  Sorting
Users can sort animal records by:
- Name (A–Z or Z–A)
- Size (Smallest to Largest or Largest to Smallest)
- Age (Youngest to Oldest or Oldest to Youngest)

Sorting is now handled server-side using MongoDB’s `.sort()` method, allowing results to be returned in the correct order without requiring client-side sorting of large datasets.

###  Pagination
Results are limited to 6 per page. When a user navigates pages, MongoDB returns only the records for that specific range using `.skip()` and `.limit()` functions. This keeps API responses lightweight and responsive, regardless of the total dataset size.

---

## Big O Notation and Algorithmic Complexity

The original Java version of the application handled search and filter logic using linear iteration (`for` loops), resulting in **O(n)** time complexity. This approach became inefficient as the dataset grew because every operation had to scan all elements to find matches.

The enhanced version uses **MongoDB’s indexed query mechanisms**, which reduce lookup time significantly. With proper indexing, most filtered searches now approach **O(log n)** time, making them scalable even as data grows. Sorting is also more efficient, as MongoDB handles it internally using optimized algorithms — freeing the frontend from needing to sort data manually in **O(n log n)** time.

Pagination introduces an additional optimization by only requesting a subset of results from the database. From the user's perspective, this brings perceived complexity down to **O(1)** per interaction, since only a small, relevant slice of data is transmitted and rendered.

These algorithmic improvements show how the application transitioned from a basic, linear-access design to a responsive, query-efficient system suitable for real-world use.

---

## Skills Demonstrated

- Algorithmic thinking in query design and optimization
- Backend filtering and sorting using MongoDB
- Efficient pagination and response structuring
- Avoidance of linear-time loops by using indexed queries
- Reducing computational load on the frontend by offloading data processing to the backend

---

## Related Capstone Outcome(s)

- **Outcome 3**: Design and evaluate computing solutions using algorithmic principles
- **Outcome 4**: Use well-founded and innovative techniques and tools in computing practices

---

## Summary

This enhancement modernizes the animal filtering and sorting system by eliminating in-memory processing and using optimized database queries instead. These changes demonstrate algorithmic awareness, improved time complexity, and real-world problem-solving skills. The result is a faster, more scalable application that performs well regardless of data size.

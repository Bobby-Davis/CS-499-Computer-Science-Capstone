# CS-499 Capstone - Category 2: Algorithms and Data Structures

This enhancement focuses on improving the performance, scalability, and efficiency of animal data handling in the Rescue Animal Management System. Originally created in IT-145, the application used in-memory `ArrayList`s and manual `for` loops for filtering and searching records. This was manageable for small datasets, but as data volume increased, operations became slower and more inefficient.

To address these limitations, I enhanced the system by introducing structured filtering, sorting, and pagination logic that leverages MongoDB’s native query and indexing capabilities. These enhancements significantly reduced the computational load on both the backend and frontend while providing a better user experience.

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

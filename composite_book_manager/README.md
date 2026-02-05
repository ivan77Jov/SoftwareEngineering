# Book Management System – Composite Pattern (Java)

## Overview
This project implements a hierarchical book management system using the **Composite Design Pattern**. It was developed as part of a Software Engineering course at the University of Salzburg.

The system allows individual books and collections of books to be treated uniformly, enabling flexible management of nested book structures.

---

## Features

- Representation of individual books
- Creation of nested book collections
- Uniform handling of single books and book groups
- Support for hierarchical book structures
- Recursive operations across collections

---

##  Design Pattern Used

### Composite Pattern

The Composite Pattern allows clients to treat individual objects and compositions of objects uniformly.

### Roles Implemented

- **Component**
  - Common interface for all book-related objects

- **Leaf**
  - Represents individual books

- **Composite**
  - Represents collections containing books or other collections

---

##  Software Engineering Concepts Demonstrated

- Object-Oriented Programming
- Design Pattern implementation
- Recursive data structures
- Polymorphism
- Abstraction and extensibility
- Hierarchical domain modeling

---

## Technologies Used

- Java
- Maven
- Standard Java Libraries

---

##  How to Build

Make sure Maven is installed, then run:

```bash
mvn clean install


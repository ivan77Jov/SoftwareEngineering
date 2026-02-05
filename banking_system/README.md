# Banking System (Java)

##  Overview
This project implements a simplified banking system developed as part of a Software Engineering course at the University of Salzburg. The system models customers and different types of bank accounts and supports common banking operations such as deposits, withdrawals, and transfers.

The project focuses on object-oriented design, domain modeling, and enforcing business rules within the system.

---

##  Features

- Customer registration with unique identifiers
- Personal and Corporate account types
- Deposit and withdrawal operations
- Money transfers between accounts
- Querying customer accounts
- Calculation of total balance per customer

---

##  Account Types

### Personal Account
- Owned by exactly one customer
- Negative balance is NOT allowed

### Corporate Account
- Can be owned by multiple customers
- Negative balance is allowed

---

##  Software Engineering Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Abstract base classes and inheritance
- Encapsulation of business logic
- Use of Java Collections Framework
- UUID-based unique identifier generation
- Use of `Optional` to model potentially missing values
- Financial calculations using `BigDecimal`

---

##  Technologies Used

- Java
- Maven
- Standard Java Libraries

---

##  How to Build

Make sure Maven is installed, then run:

```bash
mvn clean install

# Observer Pattern Testing – JUnit (Java)

## Overview
This project contains unit tests for an Observer-pattern-based news broadcasting system. It was developed as part of the Software Engineering course at the University of Salzburg.

The goal of this assignment was to verify system behavior using automated unit testing with JUnit 5, focusing on correct event notification, authentication, and content moderation logic.

---

## Features Tested

The test suite verifies the following functionality:

### Trusted Source Management
- Registering trusted news sources
- Preventing duplicate source registrations

### News Broadcasting
- Successful news distribution from trusted sources
- Authentication validation for source access
- Exception handling for untrusted or unauthorized sources

### Content Moderation
- Blocking restricted words
- Redacting blocked content
- Restoring normal behavior after removing blocked words

### Observer Notification
- Observers receiving updates when news is published
- Observers no longer receiving updates after removal

---

## Testing Techniques Demonstrated

- Unit testing using JUnit 5
- Exception testing using `assertThrows`
- Test setup using `@BeforeEach`
- Use of test doubles (mock observers)
- Behavioral verification of event-driven systems

---

## Software Engineering Concepts Demonstrated

- Test-driven thinking
- Verification of event-driven architecture
- Validation of authentication and authorization logic
- Testing state changes and side effects
- Automated regression testing

---
## Technologies Used

- Java
- JUnit 5
- Maven

---

## How to Run Tests

Make sure Maven is installed, then run:

```bash
mvn test


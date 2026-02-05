# News Broadcasting System – Observer Pattern (Java)

## Overview
This project implements a news broadcasting system using the **Observer Design Pattern**. It was developed as part of a Software Engineering course at the University of Salzburg.

The system models a news publisher that distributes updates to multiple subscribers. It demonstrates event-driven communication and loose coupling between system components.

---

## Features

- News publisher that manages subscribers
- Dynamic subscription and unsubscription
- Automatic notification of subscribers when news updates occur
- Support for multiple observers receiving updates simultaneously

---

## Design Pattern Used

### Observer Pattern

The Observer Pattern allows objects (observers/subscribers) to receive automatic updates when the state of another object (subject/publisher) changes.

### Roles Implemented

- **Subject / Publisher**
  - Maintains a list of subscribers
  - Notifies subscribers about updates

- **Observers / Subscribers**
  - Receive notifications from publisher
  - React to new news updates

---

## Software Engineering Concepts Demonstrated

- Object-Oriented Programming
- Interface-based design
- Loose coupling between components
- Event-driven architecture
- Separation of concerns

---

## Technologies Used

- Java
- Maven
- Standard Java Libraries

---

## How to Build

Make sure Maven is installed, then run:

```bash
mvn clean install


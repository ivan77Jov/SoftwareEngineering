# Minesweeper Game (Java)

## Overview
This project implements the classic Minesweeper game in Java. It was developed as part of the Software Engineering course at the University of Salzburg.

The project focuses on implementing game logic, grid-based data structures, and recursive tile reveal algorithms.

---

## Features

- Random mine placement
- Tile reveal logic with recursive expansion
- Flagging of suspected mine locations
- Win and loss detection
- Interactive game state management

---

## Game Rules

- The board consists of tiles that may contain mines.
- Revealing a tile shows the number of adjacent mines.
- Revealing a mine ends the game.
- Revealing an empty tile automatically reveals neighboring tiles.
- The player wins when all safe tiles are revealed.

---

## Software Concepts Demonstrated

- Object-Oriented Programming
- Grid-based data modeling
- Recursive algorithms (flood fill)
- State management
- Randomized board generation

---

## Technologies Used

- Java
- Maven (if applicable)
- Standard Java Libraries

---

## How to Run

Build the project using Maven:

```bash
mvn clean install

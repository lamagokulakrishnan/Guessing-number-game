# Guessing Number Game

Welcome to the **Guessing Number Game**! This is a web-based game built using **Spring Boot**, **PostgreSQL**, and **Liquibase** for database management. The game involves guessing a randomly generated 4-digit number within a limited number of moves, with feedback on each guess. The game tracks the player's progress and records the best scores based on time and moves.

## Features
- **Start a New Game**: Enter your name and start a new game.
- **Guess the Number**: The system generates a 4-digit number. You try to guess it, and the system provides feedback using `+` and `-`:
  - `+` means the digit is correct and in the right position.
  - `-` means the digit is correct but in the wrong position.
- **Database Tracking**: Player's scores (time and number of moves) are stored in a PostgreSQL database.
- **Best Score**: The best score is calculated based on the combination of time and number of guesses and displayed after each successful guess.

## Requirements
- **Java 11+**
- **Spring Boot** (Used for backend development)
- **PostgreSQL** (Used for data storage)
- **Liquibase** (For database schema versioning)

## Installation

### 1. Clone the repository
Clone this repository to your local machine.

```bash
git clone https://github.com/your-username/guessing-number-game.git

2. Set up the database

Make sure PostgreSQL is installed and running on your machine. Create a new database for the game.

CREATE DATABASE guessing_number_game;

3. Configure application.properties

In the src/main/resources/application.properties, configure the PostgreSQL connection settings:

spring.datasource.url=jdbc:postgresql://localhost:5432/guessing_number_game
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.liquibase.enabled=true

4. Liquibase Configuration

The database schema is managed using Liquibase. Ensure the changelog files are set up correctly in the project to initialize your database.

5. Run the Application

You can run the Spring Boot application using Maven:

mvn spring-boot:run

Alternatively, you can build the project and run it with the jar file:

mvn clean install
java -jar target/guessing-number-game-0.0.1-SNAPSHOT.jar

API Endpoints

1. Start a New Game

POST /api/game/start

Request Body:

{
  "playerName": "Your Name"
}


2. Make a Guess

POST /api/game/guess

Request Parameters:

guess (String): The 4-digit number you are guessing.

playerName (String): Your name.


Example request body:

{
  "guess": "1213",
  "playerName": "lama"
}

Response:

The system will respond with feedback based on your guess.

If the guess is correct, you'll receive a congratulatory message along with the number of moves and time taken.



3. Best Score

GET /api/game/best-score

Response:

The player with the best score (lowest combined time and moves).



Database Schema

The game stores the following information:

playerName: The name of the player.

moves: The number of moves the player took to guess the correct number.

duration: The time taken to finish the game in seconds.

score: A combination of time and moves (lower is better).


The database schema is automatically generated and managed using Liquibase.

Contributing

We welcome contributions! Feel free to fork the repository, create a new branch, and submit a pull request with your changes. Here's a basic flow for contributing:

1. Fork the repository.


2. Clone the forked repository to your local machine.


3. Create a new branch (git checkout -b feature-name).


4. Make your changes and commit them (git commit -am 'Add new feature').


5. Push the branch (git push origin feature-name).


6. Create a pull request.



License

This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgements

Spring Boot for backend development.

PostgreSQL for database management.

Liquibase for database versioning.


### Key Sections in the README:
1. **Project Overview**: Describes the game's functionality and how it works.
2. **Requirements**: Lists the prerequisites needed to run the project.
3. **Installation Instructions**: Walks through the setup process.
4. **API Endpoints**: Provides details of the API endpoints to interact with the game.
5. **Database Schema**: Explains the structure of the database and the data being stored.
6. **Contributing**: Guides contributors on how to help improve the project.
7. **License**: Includes licensing information.

Make sure to replace `"https://github.com/your-username/guessing-number-game.git"` with the actual link to your repository.

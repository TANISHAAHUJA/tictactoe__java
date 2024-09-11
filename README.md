***Tic-Tac-Toe Game***

Welcome to the Tic-Tac-Toe Game! This is a classic implementation of the Tic-Tac-Toe game with some modern features like score tracking and game restart functionality. Developed using Java Swing, this game allows two players to compete against each other on a 3x3 grid.

**Features**

*Two-Player Gameplay: Players alternate turns to place their marks (X or O) on the board.

*Restart Game: After a win or a tie, players can restart the game without closing the application.

*Score Tracking: Keeps track of the number of wins for each player and displays the scores.

*Visual Feedback: Winning moves are highlighted, and ties are clearly indicated.

![Main Game Window](src/images/tic-tac-toe1.png)
![Main Game Window](src/images/tic-tac-toe2.png)


**Requirements**

Java 22.0.2 or newer
IntelliJ IDEA or any other Java IDE
Java Development Kit (JDK) installed on your machine


**Usage**

Starting the Game: Upon starting the game, you'll see a 3x3 grid and a status label indicating whose turn it is.

Playing the Game: Click on an empty cell to place your mark. The game will automatically check for a winner or a tie after each move.

Restarting the Game: Click the "Restart Game" button to start a new game. The scores will remain updated.

Viewing Scores: The current scores for Player X and Player O are displayed at the top of the window.

****How It Works****

Game Logic: The game alternates between Player X and Player O, checking for wins or ties after each move.

Winning Condition: The game checks rows, columns, and diagonals for three matching marks.

Tie Condition: The game detects a tie if all cells are filled without a winner.

Score Tracking: Scores are updated and displayed based on wins, and the game state is reset after each restart.

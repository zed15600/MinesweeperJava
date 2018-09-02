# MinesweeperJava

Console version of the videogame "Minesweeper" coded in the Java programming language using the Netbeans IDE.

## RUN

To run this program, open a console and move to the project root folder ("Minesweeper"), then run:

	$ java -jar Minesweeper.jar

### Consideration

For the first input, the user must insert, separated by spaces, the ammount of rows of the board, the ammount of columns of the board and the ammount of mines, respectively. The ammount of mines must be less than the number of cells in the board (rows*columns), otherways the user must repeat this input until a correct board is defined.

Each turn, the player must insert, also separating by spaces, a cell using the board coordinates (starting at 0 for both axes), and the kind of movement "M" for mark a cell or "U" for uncover such cell. In the case of the user inputs a wrong movement, the board will be reprinted unaltered waiting for a new movement.

To win the game, the user must mark each and only each cell containing a mine. The marked cells can not be unmarked, unless the user inputs a movement to uncover such marked cell.
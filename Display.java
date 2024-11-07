import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Display {

  // constructor
  public Display() {
  }

  // methods
  // print message for invalid number input for connectN
  public void invalidConnectN() {
    System.out.println("You have not entered an integer in the range 2 > N > 7. You will play Connect4.");
  }

  // print instructions to player
  public void printInstructions(int n) {
		System.out.println("\nWelcome to Connect " + n + ".\nThere are 3 players: red, yellow and blue.\nYou are playing against two computer players.\nA player wins by connecting " + n + " counters in a row\n(vertically, horizontally or diagonally)\n");
  }

  // print board 
  public void printBoard(Board boardObject) {
    char[][] board = boardObject.getBoardState();
    System.out.print("\n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'r') {
					System.out.print("| r ");
				}
				else if (board[i][j] == 'y') {
					System.out.print("| y ");
				}
        else if (board[i][j] == 'b') {
          System.out.print("| b ");
        }
				else {
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
    System.out.print("\n\n");
	}

  // print message to prompt colour input
  public void promptColourInput(){
    System.out.println("Enter r for red, y for yellow or b for blue:");
  }

  // print message for invalid colour input
  public void invalidColourInput(){
    System.out.println("Please enter either r, y or b.");
  }

  // print message to prompt column input
  public void promptColumnInput() {
    System.out.print("Enter the column you want to drop your counter in: ");
  }

  // print message for invalid column input
  public void invalidColumnInput() {
    System.out.println("Please enter a valid number between 1 and 7");
  }

  // print message indicating computer player's turn
  public void printPlayerTurn(String player) {
    System.out.println(player + "'s turn.");
  }

  // print message to say column is full
  public void printColumnFull() {
    System.out.println("Column full.");
  }

  // print winning message
  public void printWinningMessage(String player) {
    System.out.println(player + " has won!");
  }

  // print message for game over, when board is full
  public void printGameOver() {
    System.out.println("Board full. Game over!");
  }

}
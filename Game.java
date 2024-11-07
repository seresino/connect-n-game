
public class Game {
	
  // fields
  private Board board;
  private Display display;
  private int n;
	
  // constructor
	public Game(int n) {
    display = new Display();
    board = new Board();
    board.createEmptyBoard();
    this.n = n;
	}
	
  // method to play game
	public void playGame() {
		
    // print instructions
    display.printInstructions(n);

    // assign players to tokens
    display.promptColourInput();
    HumanPlayer player1 = new HumanPlayer(' ', 1);
    ComputerPlayer player2 = new ComputerPlayer(' ', 2);
    ComputerPlayer player3 = new ComputerPlayer(' ', 3);
    boolean valid = false;
    while (!valid) {
      String input = player1.getUserInput(); 
      if (input.equals("r")) { 
        player1.changeToken('r');
        player2.changeToken('y');
        player3.changeToken('b');
        valid = true;
      }
      else if (input.equals("y")) {
        player1.changeToken('y');
        player2.changeToken('b');
        player3.changeToken('r');
        valid = true;
      }
      else if (input.equals("b")) {
        player1.changeToken('b');
        player2.changeToken('r');
        player3.changeToken('y');
        valid = true;
      }
      else {
        display.invalidColourInput();
      }
    }
		
    display.printBoard(board);

    // start with human player1
    Player player = player1;

    // each while loop represents one turn
    while (!board.hasWon()) {
      String playerNumber = "Player" + player.getPlayerNumber();
      display.printPlayerTurn(playerNumber);

      // if human player, prompt player for move:
      if (player.equals(player1)) {
        display.promptColumnInput();
      }

			// place token
      boolean placed = false;
      while (!placed) {
        if (player.checkMove()) {
          int move = player.getMove();
          if (board.placeToken(player.getToken(), move) == true) {
            placed = true;
          }
          else {
            display.printColumnFull();
          }
        }
        else {
          display.invalidColumnInput();
        }
      }

			display.printBoard(board);

      // check for win
      board.checkForN(player.getToken(), n);
      if (board.hasWon()) {
        display.printWinningMessage(playerNumber);
      }

      // check for full board & exit loop if full
      if (board.checkBoardFull()) {
        display.printGameOver();
        break;
      }

			// switch player
      if (player.equals(player1)) {
        player = player2;
      }
      else if (player.equals(player2)) {
        player = player3;
      }
      else {
        player = player1;
      }
		}
	}

}

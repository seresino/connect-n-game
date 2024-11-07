
public class Board {

  // fields
  private char[][] board;
  private boolean win;

  // constructor
  public Board() {
    this.board = new char[6][7];
    this.win = false;
  }

  // accessor to return current state of board
  public char[][] getBoardState() {
    return board;
  }

  // accessor for win
  public boolean hasWon() {
    return win;
  }

  // method to create empty board
	public void createEmptyBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

  // method to place counter on board
	public boolean placeToken(char token, int col) {
		for (int i = board.length-1; i >= 0; i--) {
			if (!checkSlotFull(i, col-1)) {
				board[i][col-1] = token;
				return true;
			}
		}
		return false;
	} 

  // method to check if slot is full
  private boolean checkSlotFull(int row, int col) {
    if (board[row][col] == ' ') {
      return false;
    }
    return true;
  }

  // method to check if board is full
  public boolean checkBoardFull() {
	    for (int i = 0; i < board.length; i++) {
	    	for (int j = 0; j < board[0].length; j++) {
	    		if (board[i][j] == ' ') {
	    			return false;
	    		}
	    	}
	    }
	    return true;
	}  	

  // method to check for 4 in a row
  private boolean checkRows(char token, int n) {
    int count;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length - (n-1); j++) {
        count = 0;
        for (int k = 0; k < n; k++) {
          if (token == board[i][j+k]) {
            count += 1;
            if (count >= n) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  // method to check for 4 in a column
  private boolean checkColumns(char token, int n) {
    int count;
    for (int i = 0; i < board.length - (n-1); i++) {
      for (int j = 0; j < board[i].length; j++) {
        count = 0;
        for (int k = 0; k < n; k++) {
          if (token == board[i+k][j]) {
            count += 1;
            if (count >= n) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  // method to check 4 in diagonal 
  private boolean checkDiagonal(char token, int n) {
    int count;
    // check forward diagonal
    for (int i = 0; i < board.length - (n-1); i++) {
			for (int j = 0; j < board[0].length - (n-1); j++) {
				count = 0;
        for (int k = 0; k < n; k++) {
          if (token == board[i+k][j+k]) {
            count += 1;
            if (count >= n) {
              return true;
            }
          }
        }
      }
    }
    count = 0;
    // check reverse diagonal
    for (int i = board.length - 1; i >= (n-1); i--) {
			for (int j = 0; j < board[0].length - (n-1); j++) {
        count = 0;
        for (int k = 0; k < n; k++) {
          if (token == board[i-k][j+k]) {
            count += 1;
            if (count >= n) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  // mutator method for win
  public void checkForN(char token, int n) {
    if (checkRows(token, n) || checkColumns(token, n) || checkDiagonal(token, n)) {
      win = true;
    }
    else{
      win = false;
    }
  }

}

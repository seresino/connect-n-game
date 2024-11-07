
public abstract class Player {
  
  // fields
  private char token;
  private int move;
  private int playerNumber;

  // constructor
  public Player(char token, int playerNumber) {
    this.token = token;
    this.playerNumber = playerNumber;
  }
  
  // accessor method for player number
  public int getPlayerNumber() {
    return playerNumber;
  }

  // accessor method for token
  public char getToken() {
    return token;
  }

  // setter method for token
  public void setToken(char t) {
    token = t;
  }

  // accessor method for move
  public int getMove() {
    return move;
  }

  // setter method for move
  public void setMove(int m) {
    move = m;
  }

  // abstract method to check player move is valid, so it can be overriden by subclasses
  public abstract boolean checkMove();

}
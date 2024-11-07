import java.io.*;
import java.util.*;

public class ComputerPlayer extends Player {
	
	// constructor
	public ComputerPlayer(char counter, int number) {
		super(counter, number);
	} 

  // mutator method to change token
  public void changeToken(char c) {
    setToken(c);
  }

  // method to override checkMove() method from Player superclass
  @Override
	public boolean checkMove() {
    setMove(getRandomColumn());
    return true;
  }

  // method to generate random move
  private int getRandomColumn() {
		Random rn = new Random();
    int number = rn.nextInt(7) + 1;
    return number;
	}

}
  
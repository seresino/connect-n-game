import java.io.*;

public class HumanPlayer extends Player {

  // fields
  private BufferedReader input;
	
	// constructor
	public HumanPlayer(char counter, int number) {
		super(counter, number);
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
  // method to get user input from human player
  public String getUserInput() {
    String userInput = null;
    try {			
      userInput = input.readLine();
    }
    catch(Exception e) {
      System.out.println("Input error.");
    }
    return userInput;
  }

  // mutator method to change token
  public void changeToken(char c) {
    setToken(c);
  }

	// method to override checkMove() method from Player superclass
	@Override
	public boolean checkMove() {
    String input = getUserInput();
    // check user input is an integer between 1 and 7
    if ((input.length() == 1) && Character.isDigit(input.charAt(0))) {
      int m = Integer.parseInt(input);
      if ((m >= 1) && (m <= 7)) {
        setMove(m);
        return true;
      }
    }
    return false;
  }

}
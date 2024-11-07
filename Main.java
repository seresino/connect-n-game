class Main {
  public static void main(String[] args) {

    String connectN;
    int n;
    Display d = new Display();

    // if nothing is entered to the command line, play default game of Connect4
    if (args.length == 0) {
      connectN = "4";
    }
    else {
      connectN = args[0];
    }

    // check command line input is an integer between 1 and 7
    if ((connectN.length() == 1) && Character.isDigit(connectN.charAt(0))) {
      n = Integer.parseInt(connectN);
      if ((n >= 1) && (n <= 7)) {
        // skip
      }
      else {
        d.invalidConnectN();
        n = 4;
      }
    }
    else {
      d.invalidConnectN();
      n = 4;
    }
    
    Game g = new Game(n);
    g.playGame();
  }
}
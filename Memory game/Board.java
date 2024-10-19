import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Board  extends Level{
	public static String [][] board = new String[4][4];
    public static String [][] cards = new String[4][4];
    public static Scanner scanner = new Scanner(System.in);
    
    public void printFirstBoard(){
      setXY(getLevel());
      for(int i = 0; i<getXY(); i++){
        for(int j = 0; j<getXY(); j++){
          board[i][j] = " _ ";
          }
        }
    }
    
    public void printBoard(){
        printLevel();
        //System.out.println("     C1  C2  C3  C4");
        for (int i = 0; i < 4; i++){
          System.out.print(" ");
        }
        for (int i = 0; i<getXY(); i++){
          int c = i + 1;
          System.out.print("C" + c + "  ");
        }
        System.out.println("");
        
        for(int i = 0; i<getXY(); i++){
            int r = i+1;
            System.out.print("R" + r + " |");
            for(int j = 0; j<getXY();j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void playAgain(){
//    	while(true) 
    	{
      System.out.println("press Y to play again or N to exit?");
      String again = scanner.next();

      if (again.equals("Y")){
        upLevel();
        shuffleCards();
        printBoard();
        checkInput();
      } else{
          System.exit(1);
      }
    }
   }

    public void shuffleCards(){
        Random random = new Random();
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("!");
        letters.add("@");
        letters.add("#");
        letters.add("$");
        letters.add("%");
        letters.add("^");
        letters.add("&");
        letters.add("*");
        letters.add("!");
        letters.add("@");
        letters.add("#");
        letters.add("$");
        letters.add("%");
        letters.add("^");
        letters.add("&");
        letters.add("*");

        int index;
        for(int i = 0; i<getXY(); i++){
            for(int j = 0; j<getXY(); j++){
                index = random.nextInt(letters.size());
                cards[i][j] = letters.get(index);
                letters.remove(index);
            }
        }
    }

    public void checkInput(){
      int guess = 0;
        while(true){
            if(!gameOver()){
                System.out.println("Row: (1-4)");
                int row1 = scanner.nextInt();

                if(row1 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                System.out.println("Column: (1-4)");
                int column1 = scanner.nextInt();

                if(column1 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                  }

                if(!board[row1-1][column1-1].equals(" _ ")) {
                    System.out.println("Already Entered");
                    board[row1 - 1][column1 - 1] = " _ ";
                    System.out.println();

                    continue;
                }
                  else{
                    board[row1-1][column1-1] = " " + cards[row1-1][column1-1] + " ";
                    printBoard();
                }

                System.out.println("Row: (1-4)");
                int row2 = scanner.nextInt();

                if(row2 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();

                if(column2 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                if(!board[row2-1][column2-1].equals(" _ ")) {
                    System.out.println("Already Entered");
                    board[row1 - 1][column1 - 1] = " _ ";
                    System.out.println();

                    printBoard();
                    continue;
                }else{
                    board[row2-1][column2-1] = " " + cards[row2-1][column2-1] + " ";

                    if (board[row1-1][column1-1].equals(board[row2-1][column2-1])) {
                        printBoard();
                        System.out.println("Correct!");
                        board[row1-1][column1-1] = " * ";
                        board[row2-1][column2-1] = " * ";
                    }else{
                        printBoard();
                        System.out.println("False!!");
                        board[row1-1][column1-1] = " _ ";
                        board[row2-1][column2-1] = " _ ";
                        printBoard();
                    }
                }
                guess++;
            }else {
                guess++;
                printBoard();
                System.out.println("Game Over");
                System.out.println("You won!!");
                System.out.println("It took you " + guess + " guesses to win!");
//                printFirstBoard();
                playAgain();
            }
        }

    } 

    public boolean gameOver(){
        for(int i = 0; i<getXY(); i++){
            for(int j = 0; j<getXY();j++){
                if(board[i][j].equals(" _ ")){
                    return false;
                }
            }
        }
        return true;
        }
            public static void main(String[] args) {
        Board game = new Board();
        game.printFirstBoard();
        game.shuffleCards();
        game.printBoard();
        game.checkInput();
    }
}
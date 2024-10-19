import java.util.Scanner;

public class Main 
{
	 public static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {

	        Board myBoard = new Board();
	        myBoard.getLevel();
	        
	        while(true){
	            System.out.println("Press n for new game, q to quit");
	            String nq = scanner.nextLine();
                
	            if(nq.equals("q"))
                {
	                System.out.println("Exiting...");
	                break;
	            }
                else if(nq.equals("n")){
	                myBoard.shuffleCards();
	                myBoard.printFirstBoard();

	                myBoard.printBoard();
	                myBoard.checkInput();
	               
	                myBoard.playAgain();

	            }else{
	                System.out.println("Invalid character");
	                //continue;
                }
	            
	    }

	    }
}
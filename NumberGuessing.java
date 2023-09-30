package nandhini;
import java.util.*;
public class NumberGuessing {
	static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessing C = new NumberGuessing();
        C.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessing C = new NumberGuessing();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1. Play the Game");
        System.out.println("2. Score Board");
        System.out.println("3. Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int m = sc.nextInt();
            switch (m) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
                    int nRange = sc.nextInt();
                    int rNumber = C.randomNumber(nRange);
                    C.guessNumber(rNumber);
                    break;
                case 2:
                    C.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int nRange) {
        Random random = new Random();
        int rNumber = random.nextInt(nRange) + 1;
        return rNumber;
    }
    public void guessNumber(int rNumber) {
        Scanner sc = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = sc.nextInt();
            guess++;
            if (userGuess > rNumber) {
                System.out.println("Lower");
            } else if (userGuess < rNumber) {
                System.out.println("Higher");
            }
        } while (rNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }

}

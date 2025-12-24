package NumberGuessingGame;

import java.util.Scanner;

public class GameProgram {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n");
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)\n");
        System.out.println("Each difficulty level has different number of chances.\n" +
                "If chances reach 0 without guessing correct number, a GAME OVER message will be displayed\n");
        Scanner input = new Scanner(System.in);

        int userchoice = 0;
        boolean isvalid = false;
        while (!isvalid) {
            System.out.print("Enter your choice: ");
            if (input.hasNextInt()) {
                userchoice = input.nextInt();
                if (userchoice <= 3 && userchoice >= 1) {
                    isvalid = true;
                }
                else {
                    System.out.println("Invalid choice! Please enter number in front of difficult level!");
                }
            }
            else {
                System.out.println("Invalid choice! Please enter number in front of difficult level!");
                input.next();
            }
        }

        System.out.println("Great! You have selected the " + (userchoice == 3 ? "Hard" : (userchoice == 1 ? "Easy": "Medium")) +" difficulty level.\n" +
                "Let's start the game!\n");

        Game main = new Game(userchoice);
        int chances = main.getChances();
        int userguess;
        while (chances > 0) {
            System.out.print("Enter your guess: ");
            if (input.hasNextInt()) {
                userguess = input.nextInt();
                if (userguess == main.getSystemNumber()) {
                    System.out.println("Congratulations! You guessed the correct number in "+ (main.getChances() - chances) +" attempts.");
                        return;
                }
                else if (userguess > main.getSystemNumber()) {
                    System.out.println("Incorrect! The number is less than "+userguess+".");
                }
                else if (userguess < main.getSystemNumber()) {
                    System.out.println("Incorrect! The number is greater than "+userguess+".");
                }
                chances--;
            }
            else {
                System.out.println("Invalid guess! Please enter number");
                input.next();
            }
        }

    }
}

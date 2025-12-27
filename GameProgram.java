import java.util.Scanner;

public class GameProgram {
    static int Score = 0;
    public static void GameLogic() {
        //Show game rule
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances \\ 5 hints)\n" +
                "2. Medium (5 chances \\ 3 hints)\n" +
                "3. Hard (3 chances \\ 2 hints)\n");
        System.out.println("Each difficulty level has different number of chances.\n" +
                "If chances reach 0 without guessing correct number, a GAME OVER message will be displayed\n" +
                "You are give a number of hints that help you know the range in which number you need to guess falls \n" +
                "(for example, 50 falls within the range of 47~53)\n");
        //Score rule
        System.out.println("If you guess the correct number, the result is determined based on the time taken for your guess," +
                "\n the number of remaining chances and the number of remaining hints." +
                "\nThe better you guess with less time, fewer guessing chances used and less use of hints" +
                "\nThe higher the score.\n");
        Scanner input = new Scanner(System.in);
        //Validate difficult level choice
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
        //Validate user guess
        Game main = new Game(userchoice, userchoice);
        //Check time guess
        long start = System.currentTimeMillis();
        int score = 0;
        main.setHighest(Score);
        int chances = main.getChances();
        int hints = main.getHints();
        int userguess = 101;

        while (chances > 0) {
            System.out.print("Enter your guess (enter H or h to display hint): ");
            if (input.hasNextInt()) {
                userguess = input.nextInt();
                //Game logic
                if (userguess == main.getSystemNumber()) {
                    long time = (System.currentTimeMillis() - start) / 1000;
                    if (time <= 10) score += 10;
                    else if (time <= 20) score += 5;
                    else score += 3;
                    score += (hints* 30) / main.getHints()  +  (chances * 60) / main.getChances() ;
                    if (score > main.getHighest()) {
                        main.setHighest(score);
                        Score = score;
                    }
                    System.out.println("Congratulations! " +
                            "\nYou guessed the correct number in "+ (main.getChances() - chances) +" attempts." +
                            "\nYou guessing time is " + time + "." +
                            "\nYou still have " + hints + " hints left." +
                            "\nYour highest score is " + main.getHighest() +"." +
                            "\nYour current score is " + score +".\n");
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
                String temp = input.next();

                if (hints > 0 && temp.equalsIgnoreCase("h")) {
                    int head = main.getSystemNumber() - hints - 1;
                    int tail = main.getSystemNumber() + hints + 1;
                    if (head < 1) head = 1;
                    if (tail > 100) tail = 100;
                    System.out.println("The number is in range of " + head + " ~ " + tail);
                    hints--;
                }
                else {
                    if (hints == 0 && temp.equalsIgnoreCase("h")) {
                        System.out.println("You have ran out of hints!");
                    } else {
                        System.out.println("Invalid input! Please enter a number or 'h' for hint.");
                    }
                }
            }
        }
        System.out.println("\nGAME OVER! you've run out of chance\n");
    }
    //For play again
    public static void Restart() {
        GameLogic();
        System.out.println("If you guess the correct number, the result is determined based on the time taken for your guess," +
                "\n the number of remaining chances and the number of remaining hints." +
                "\nThe better you guess with less time, fewer guessing chances used and less use of hints" +
                "\nThe higher the score.\n");
        System.out.println("Do you want to play again?");
        System.out.println("1. YES\n2. NO\n");
        Scanner input = new Scanner(System.in);
        //Validate choice
        while (true) {
            System.out.print("Enter your choice: ");
            if (input.hasNextInt()) {
                int test = input.nextInt();
                while (test == 1) {
                    Restart();
                }
                if (test == 2) {
                    System.out.println("Thank you for playing! Have a nice day");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid choice! Please enter number in front of choices!");
                }
            }
            else {
                System.out.println("Invalid choice! Please enter number in front of choices!");
                input.next();
            }
        }
    }
    static void main() {
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.\n");
        Restart();
    }
}

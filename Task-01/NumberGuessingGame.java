import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random at = new Random();

        // Step 1: Generate a random number
        int secretNumber = at.nextInt(100) + 1;

        int attempts = 0;
        int guess = 0;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess a number between 1 and 100");

        // Step 2: Take user input
        while (guess != secretNumber) {

            System.out.print("Enter your guess: ");
            guess = in.nextInt();

            attempts++;

            // Step 3: Provide hints
            if (guess < secretNumber) {
                System.out.println("Higher! Try again.");
            }
            else if (guess > secretNumber) {
                System.out.println("Lower! Try again.");
            }
            else {
                // Step 5: Display result
                System.out.println("Correct!");
                System.out.println("You guessed the number in " + attempts + " attempts.");
            }
        }

        in.close();
    }
}

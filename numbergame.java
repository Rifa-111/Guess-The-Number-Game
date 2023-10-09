/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guess_the_word.game;

/**
 *
 * @author rifa
 */
import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number!");
        System.out.println("Select a difficulty level:");
        System.out.println("1. Easy (1-50, 15 attempts)");
        System.out.println("2. Medium (1-100, 10 attempts)");
        System.out.println("3. Hard (1-200, 5 attempts)");

        int choice = scanner.nextInt();
        DifficultyLevel selectedLevel = getDifficultyLevel(choice);

        int lowerBound = selectedLevel.getLowerBound();
        int upperBound = selectedLevel.getUpperBound();
        int numberOfAttempts = selectedLevel.getNumberOfAttempts();

        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess = -1; // Initialize with a default value
        int attempts = 0;
        int hintsUsed = 0;

        System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + numberOfAttempts + " attempts to guess it.");

        while (attempts < numberOfAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess within the valid range.");
                continue;
            }

            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number correctly: " + secretNumber);
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

            if (attempts < numberOfAttempts) {
                System.out.print("Would you like a hint? (yes/no): ");
                String hintChoice = scanner.next().toLowerCase();
                if (hintChoice.equals("yes") && hintsUsed < selectedLevel.getMaxHints()) {
                    displayHint(secretNumber, userGuess);
                    hintsUsed++;
                }
            }
        }

        if (attempts == numberOfAttempts && userGuess != secretNumber) {
            System.out.println("Sorry, you've run out of attempts.");
            System.out.println("The secret number was: " + secretNumber);
        }

        scanner.close();
    }

    private static DifficultyLevel getDifficultyLevel(int choice) {
        switch (choice) {
            case 1:
                return new DifficultyLevel("Easy", 1, 50, 15, 3);
            case 2:
                return new DifficultyLevel("Medium", 1, 100, 10, 2);
            case 3:
                return new DifficultyLevel("Hard", 1, 200, 5, 1);
            default:
                return new DifficultyLevel("Medium", 1, 100, 10, 2);
        }
    }

    private static void displayHint(int secretNumber, int userGuess) {
        if (userGuess < secretNumber) {
            System.out.println("Hint: The secret number is higher than your guess.");
        } else {
            System.out.println("Hint: The secret number is lower than your guess.");
        }
    }
}

class DifficultyLevel {
    private String name;
    private int lowerBound;
    private int upperBound;
    private int numberOfAttempts;
    private int maxHints;

    public DifficultyLevel(String name, int lowerBound, int upperBound, int numberOfAttempts, int maxHints) {
        this.name = name;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.numberOfAttempts = numberOfAttempts;
        this.maxHints = maxHints;
    }

    public String getName() {
        return name;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getMaxHints() {
        return maxHints;
    }
}

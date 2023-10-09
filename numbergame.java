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

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 10;
        
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        System.out.println("Welcome to Guess the Number!");
        System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + numberOfAttempts + " attempts to guess it.");
        
        for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess within the valid range.");
                continue;
            }
            
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number correctly: " + secretNumber);
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
            
            if (attempt == numberOfAttempts) {
                System.out.println("Sorry, you've run out of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }
        }
        
        scanner.close();
    }
}

package com.LeafandLoaf.util;

import java.util.Scanner;

public class InputHelper {

    // Static scanner
    private static final Scanner userInput = new Scanner(System.in);

    // Method to print out questions to user,
    // take in response and returns the full input as string
    public static String getString(String question) {
        System.out.println(question);
        return userInput.nextLine();
    }

    // Method to print out questions to user,
    // take in response and returns the full input as int
    public static int getInt(String question) {
        System.out.println(question);

        // If the  user input is not a number it loops
        // shows an error message and asks again
        while (!userInput.hasNextInt()) {
            System.out.println("Invalid input. " + question);

            // Deletes the invalid input
            userInput.next();
        }

        // Stores the user input in variable input
        int input = userInput.nextInt();

        // Eats newline
        userInput.nextLine();

        // Returns valid input
        return input;
    }

    // Method to print out questions to user,
    // take in y/n and returns true if y and false if n
    public static boolean confirm(String question) {
        String userInput;

        // Loops until user types exactly y or n
        do {
            userInput = getString(question + " (y/n): ").trim().toLowerCase();
        } while (!userInput.equals("y") && !userInput.equals("n"));

        // Returns true if user input is y
        return userInput.equals("y");
    }

}

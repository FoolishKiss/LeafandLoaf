package com.LeafandLoaf.util;

public class UIHelper {

    // ANSI color codes
    public static final String RESET = "\u001B[0m"; // Reset text back to default
    public static final String RED = "\u001B[31m"; // For error messages
    public static final String GREEN = "\u001B[32m"; // For successful confirmation
    public static final String YELLOW = "\u001B[33m"; // For warnings or prompts
    public static final String BLUE = "\u001B[34m"; // For headings
    



    // Method to type out eac character of a string with a delay
    public static void typeText(String message, int delayMillis) {

        // Loop through each character of the string
        for (char ch : message.toCharArray()) {

            // Print character without line breaks
            System.out.print(ch);

            try {
                // Stops for specified time
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                // Picks back where it left off
                Thread.currentThread().interrupt();
            }
        }
        // Prints new line after messages is printed out
        System.out.println();
    }

    // Method to show a load spinner animation
    public static void showSpinner(int durationSeconds) {

        // Array of characters for spinner
        String[] spinner = {"|", "/", "-","\\"};

        // Calculate end time
        long endTime = System.currentTimeMillis() + (durationSeconds * 1000);

        // Index counter
        int i = 0;

        // Run until time is up
        while (System.currentTimeMillis() < endTime) {

            // Display spinner by looping through list of spinner. \r moves cursor back
            System.out.print("\r" + spinner[i++ % spinner.length] + " Preparing...");
            try {
                // Delay between frames
                Thread.sleep(150);

            } catch (InterruptedException e) {
                // Handle thread interruption
                Thread.currentThread().interrupt();
            }
        }
        // Display done message
        UIHelper.warning("\rDone      \n");
    }

    // Method to print a divider line
    public static void divider() {

        // Horizontal divider line of 40 dashes
        System.out.println("-".repeat(40));
    }

    // Method to print a header with format
    public static void heading(String text) {
        System.out.println(BLUE + "\n=== " + text + "===\n" + RESET);
    }
    

    // Method to a color to a string
    public static void printColor(String message, String color) {
        System.out.println(color + message + RESET);
    }

    // Success message
    public static void success(String message) {
        printColor(message, GREEN);
    }

    // Warning message
    public static void warning(String message) {
        printColor(message, YELLOW);
    }

    // Error message
    public static void error(String message) {
        printColor(message, RED);
    }



}

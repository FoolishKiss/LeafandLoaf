package com.LeafandLoaf.data;

import com.LeafandLoaf.models.Order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

// This class manages the flow of ordering
public class OrderDataManager {

    // Holds the current order the user is making
    private Scanner userinput = new Scanner(System.in);
    private Order currentOrder;
    private int orderId = 1;

    // Starts the order flow
    public void startOrder() {

        // Controls the to keep the app running
        boolean running = true;

        // Start loop
        while (running) {
            System.out.println("\nWelcome to Leaf and Loaf\n");
            System.out.println("1) Start New Order");
            System.out.println("2) Exit");
            System.out.println("Choose an option: \n");

            // Gets the users number input
            int choice = userinput.nextInt();
            userinput.nextLine(); // Eats new line

            // Switch based off users input calls createNewOrder method or exit app
            switch (choice) {
                case 1: createNewOrder(); break;
                case 2: System.out.println("Thank you. GoodBye!");
                    running = false; break;
                // If user types anything besides 1 or 2 print message
                default:
                    System.out.println("Invalid option. Try again.");
            }

        }

    }

    // Method the start a new order
    private void createNewOrder() {

        // Creates a new order
        currentOrder = new Order(orderId, LocalDate.now(), LocalTime.now());

        // Controls order menu loop
        boolean ordering = true;

        // Starts order menu loop
        while (ordering) {
            System.out.println("\nOrder Menu:\n");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) View Order Receipt");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choose an option: \n");

            // Gets the users number input
            int input = userinput.nextInt();
            userinput.nextLine(); // Eats new line

            switch (input) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    System.out.println(currentOrder.summary());
                    break;
                case 5:
                    checkout();
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Method to add a sandwich
    public void addSandwich() {
        // TODO: Add sandwich flow logic
        return;
    }

    // Method to add a drink
    public void addDrink() {
        // TODO: Add drink logic
        return;
    }

    // Method to add chips
    public void addChips(){
        // TODO: Add chip logic

        return;
    }

    //Method to check out
    public void checkout() {
        // TODO: Add checkout logic
        return;
    }


}

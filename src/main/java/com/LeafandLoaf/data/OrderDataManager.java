package com.LeafandLoaf.data;

import com.LeafandLoaf.models.*;
import com.LeafandLoaf.models.enums.BreadType;
import com.LeafandLoaf.models.enums.DrinkSize;
import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;
import com.LeafandLoaf.util.InputHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("0 ) Cancel Order");
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

        // Lets user know that they started the sandwich process
        System.out.println("\nBuilding your sandwich...");

        // Ask user for size choice
        System.out.println("\nChoose a size:");
        System.out.println("1) 4 inch ($5.50)");
        System.out.println("2) 8 inch ($7.00)");
        System.out.println("3) 12 inch ($8.50)");

        // Stores user choice as int using inputHelper
        int sizeChoice = InputHelper.getInt("Enter Choice: ");

        // Coverts user number to Size enum defaults to 8 inch
        Size size = switch (sizeChoice) {
            case 1 -> Size.FOUR;
            case 2 -> Size.EIGHT;
            case 3 -> Size.TWELVE;
            default -> Size.EIGHT;

        };

        // Ask user for bread choice
        System.out.println("\nChoose bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

        // Stores user choice as int using inputHelper
        int breadChoice = InputHelper.getInt("Enter Choice: ");

        // Coverts user number to BreadType enum defaults to wheat
        BreadType bread = switch (breadChoice) {
            case 1 -> BreadType.WHITE;
            case 2 -> BreadType.WHEAT;
            case 3 -> BreadType.RYE;
            case 4 -> BreadType.WRAP;
            default -> BreadType.WHEAT;

        };

        // Ask user if they want the sandwich toasted
        boolean toasted = InputHelper.confirm("Do you want it toasted? ");

        // Add the toppings
        List<Topping> toppings = new ArrayList<>();
        boolean addingToppings = true;

        // Starts loop asking user what toppings they want to add
        while (addingToppings) {

            System.out.println("\nChoose a topping to add:");

            // Stream to display each topping from the menu Topping.MENU list
            Topping.MENU.stream()
                    .map(t -> (Topping.MENU.indexOf(t) + 1) + ") " + t.getName())
                    .forEach(System.out::println);
            System.out.println("0) Done");

            // Reads and stores user choice as int
            int choice = InputHelper.getInt("Enter topping number: ");

            // Breaks loop if user picks 0
            if (choice == 0) break;


            // If the users choice is below 1 or above the size of the list
            // Its invalid
            if (choice < 1 || choice > Topping.MENU.size()) {
                System.out.println("Invalid choice.");
                continue;
            }

            // Gets chosen toppings and stores them in selected variable
            Topping selected = Topping.MENU.get(choice - 1);

            // Set is extra to false
            boolean isExtra = false;

            // If premium cheese or alt meat ask user if they want extra
            if (selected.getType() == ToppingType.ALTMEAT || selected.getType() == ToppingType.CHEESE) {
                isExtra = InputHelper.confirm("Do you want extra " + selected.getName() + "?");

            }

            // Add toppings to list with extra and print out topping
            Topping finalTopping = new Topping(selected.getName(), selected.getType(), isExtra);
            toppings.add(finalTopping);
            System.out.println("Added: " + finalTopping);

        }

        // Makes the sandwich and adds to order
        Sandwich sandwich = new Sandwich(size, bread, toasted, toppings);
        currentOrder.getSandwiches().add(sandwich);
        System.out.println("Sandwich added: " + sandwich);
        System.out.println("Price: $" + sandwich.calculatePrice());
    }

    // Method to add a drink
    public void addDrink() {

        // Ask user if they want to add a drik
        System.out.println("\nAdd a drink to your order");

        // Choose size
        System.out.println("Choose a size:");
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large ($3.00)");

        // Stores user choice as int
        int sizeChoice = InputHelper.getInt("Enter size: ");

        // Coverts user number to DrinkSize enum defaults to Medium
        DrinkSize size = switch (sizeChoice) {
            case 1 -> DrinkSize.SMALL;
            case 2 -> DrinkSize.MEDIUM;
            case 3 -> DrinkSize.LARGE;
            default -> DrinkSize.MEDIUM;
        };

        // Displays drink menu
        System.out.println("Choose a drink:");
        Drink.MENU.stream()
                .map(d -> (Drink.MENU.indexOf(d) + 1) + ") " +d)
                .forEach(System.out::println);

        // Ask user to choose a drink
        int drinkChoice = InputHelper.getInt("Enter drink number: ");

        // Checks if user choice is greater than or equal to 1 and less then or equal to the drink menu
    String flavor = (drinkChoice >= 1 && drinkChoice <= Drink.MENU.size())
            // If the input is valid subtract 1 otherwise default to lemonade
            ? Drink.MENU.get(drinkChoice - 1) : "Lemonade";

    // If the input is invalid it prints out this message
    if (drinkChoice < 1 || drinkChoice > Drink.MENU.size()) {
        System.out.println("Invalid drink. Defaulting to Lemonade.");
    }

    // Create and add drink to order
    Drink drink = new Drink(size, flavor);
    currentOrder.getDrinks().add(drink);

    // Display drink and cost
    System.out.println("Drink added: " + drink);
    System.out.println("Price: $" + drink.getPrice());

    }

    // Method to add chips
    public void addChips(){

        // Ask user if they want to add chips
        System.out.println("\nAdd chips to your order");

        // Display the menu using stream
        Chip.MENU.stream()
                .map(chip -> (Chip.MENU.indexOf(chip) + 1) + ") " + chip)
                .forEach(System.out::println);
        System.out.println("0) Cancel");

        // Ask user to pick a chip
        System.out.println("Enter chip number: ");
        int chipChoice = userinput.nextInt();
        userinput.nextLine();

        String chipType = (chipChoice >= 1 && chipChoice <= Chip.MENU.size())
                // If the input is valid subtract 1 otherwise default to lemonade
                ? Chip.MENU.get(chipChoice - 1) : "";

        // If the input is invalid it prints out this message
        if (chipChoice < 1 || chipChoice > Drink.MENU.size()) {
            System.out.println("Invalid chip. No chips added");
        }

        // Create and add chips to order
        Chip chips = new Chip(chipType);
        currentOrder.getChips().add(chips);

        // Display drink and cost
        System.out.println("Chips added: " + chips);
        System.out.println("Price: $" + chips.getPrice());



    }

    //Method to check out
    public void checkout() {
        System.out.println("\nFinal Order Summary:");
        System.out.println(currentOrder.summary());

        // Save to file
        ReceiptWriter.write(currentOrder);

        // Print order complete
        System.out.println("Order complete.");
    }


}

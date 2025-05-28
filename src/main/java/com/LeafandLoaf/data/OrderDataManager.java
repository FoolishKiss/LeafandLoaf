package com.LeafandLoaf.data;

import com.LeafandLoaf.models.*;
import com.LeafandLoaf.models.enums.BreadType;
import com.LeafandLoaf.models.enums.DrinkSize;
import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;
import com.LeafandLoaf.util.InputHelper;
import com.LeafandLoaf.util.UIHelper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


// This class manages the flow of ordering
public class OrderDataManager {

    // Holds the current order the user is making
    private Order currentOrder;
    private int orderId = 1;

    // Starts the order flow
    public void startOrder() {

        // Controls the to keep the app running
        boolean running = true;

        // Start loop
        while (running) {
            UIHelper.heading("Welcome to Leaf and Loaf");
            UIHelper.divider();
            System.out.println("1) Start New Order");
            System.out.println("2) Exit");
            UIHelper.divider();


            // Gets the users number input
            int choice = InputHelper.getInt("Choose an option: ");

            // Switch based off users input calls createNewOrder method or exit app
            switch (choice) {
                case 1: UIHelper.showSpinner(1); createNewOrder(); break;
                case 2: UIHelper.success("Thank you. GoodBye!");
                    running = false; break;
                // If user types anything besides 1 or 2 print message
                default:
                    UIHelper.warning("Invalid option. Try again.");
            }

        }

    }

    // Method the start a new order
    private void createNewOrder() {

        // Banner
        UIHelper.banner("\nStarting a New Order\n");


        // Creates a new order
        currentOrder = new Order(orderId, LocalDate.now(), LocalTime.now());

        // Controls order menu loop
        boolean ordering = true;

        // Starts order menu loop
        while (ordering) {

            // Heading
            UIHelper.divider();
            UIHelper.heading("Order Menu");

            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) View Order Receipt");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");

            UIHelper.divider();


            // Gets the users number input using InputHelper
            int input = InputHelper.getInt(UIHelper.YELLOW + "Choose an option: " + UIHelper.RESET);

            switch (input) {
                case 1:
                    UIHelper.typeText("Opening sandwich builder...", 20);
                    addSandwich();
                    break;
                case 2:
                    UIHelper.typeText("Adding a drink...", 20);
                    addDrink();
                    break;
                case 3:
                    UIHelper.typeText("Adding chips...", 20);
                    addChips();
                    break;
                case 4:
                    UIHelper.heading("Current Order Receipt");
                    System.out.println(currentOrder.summary());
                    break;
                case 5:
                    UIHelper.typeText("Checking out...", 20);
                    checkout();
                    ordering = false;
                    break;
                case 0:
                    UIHelper.error("Order canceled.");
                    ordering = false;
                    break;
                default:
                    UIHelper.warning("Invalid option. Try again.");
            }
        }
    }

    // Method to add a sandwich
    public void addSandwich() {

        // Lets user know that they started the sandwich process
        UIHelper.heading("Building your sandwich...");


        // Ask user for size choice
        UIHelper.divider();
        System.out.println("\nChoose a size:");
        System.out.println("1) 4 inch ($5.50)");
        System.out.println("2) 8 inch ($7.00)");
        System.out.println("3) 12 inch ($8.50)");

        // Stores user choice as int using inputHelper
        int sizeChoice = InputHelper.getInt(UIHelper.YELLOW + "Enter size choice:" + UIHelper.RESET);

        // Coverts user number to Size enum defaults to 8 inch
        Size size = switch (sizeChoice) {
            case 1 -> Size.FOUR;
            case 2 -> Size.EIGHT;
            case 3 -> Size.TWELVE;
            default -> Size.EIGHT;

        };

        // Ask user for bread choice
        UIHelper.divider();
        System.out.println("\nChoose bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

        // Stores user choice as int using inputHelper
        int breadChoice = InputHelper.getInt(UIHelper.YELLOW + "Enter bread choice: " + UIHelper.RESET);

        // Coverts user number to BreadType enum defaults to wheat
        BreadType bread = switch (breadChoice) {
            case 1 -> BreadType.WHITE;
            case 2 -> BreadType.WHEAT;
            case 3 -> BreadType.RYE;
            case 4 -> BreadType.WRAP;
            default -> BreadType.WHEAT;

        };

        // Ask user if they want the sandwich toasted
        UIHelper.divider();
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
            int choice = InputHelper.getInt(UIHelper.YELLOW + "Enter topping number: " + UIHelper.RESET);

            // Breaks loop if user picks 0
            if (choice == 0) break;


            // If the users choice is below 1 or above the size of the list
            // Its invalid
            if (choice < 1 || choice > Topping.MENU.size()) {
                UIHelper.warning("Invalid choice.");
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
            UIHelper.success("Added: " + finalTopping);
        }

        // Makes the sandwich and adds to order
        Sandwich sandwich = new Sandwich(size, bread, toasted, toppings);
        currentOrder.getSandwiches().add(sandwich);
        UIHelper.divider();
        UIHelper.typeText("Sandwich added: " + sandwich, 20);
        UIHelper.typeText("Price: $" + sandwich.calculatePrice(),20);
    }

    // Method to add a drink
    public void addDrink() {

        // Ask user if they want to add a drink
        UIHelper.heading("Add a drink to your order");

        // Choose size
        UIHelper.divider();
        System.out.println("Choose a size:");
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large ($3.00)");

        // Stores user choice as int
        int sizeChoice = InputHelper.getInt(UIHelper.YELLOW + "Enter size: " + UIHelper.RESET);

        // Coverts user number to DrinkSize enum defaults to Medium
        DrinkSize size = switch (sizeChoice) {
            case 1 -> DrinkSize.SMALL;
            case 2 -> DrinkSize.MEDIUM;
            case 3 -> DrinkSize.LARGE;
            default -> DrinkSize.MEDIUM;
        };

        // Displays drink menu
        UIHelper.divider();
        System.out.println("Choose a drink:");
        Drink.MENU.stream()
                .map(d -> (Drink.MENU.indexOf(d) + 1) + ") " +d)
                .forEach(System.out::println);

        // Ask user to choose a drink
        int drinkChoice = InputHelper.getInt(UIHelper.YELLOW + "Enter drink number: " + UIHelper.RESET);

        // Checks if user choice is greater than or equal to 1 and less then or equal to the drink menu
    String flavor = (drinkChoice >= 1 && drinkChoice <= Drink.MENU.size())
            // If the input is valid subtract 1 otherwise default to lemonade
            ? Drink.MENU.get(drinkChoice - 1) : "Lemonade";

    // If the input is invalid it prints out this message
    if (drinkChoice < 1 || drinkChoice > Drink.MENU.size()) {
        UIHelper.warning("Invalid drink. Defaulting to Lemonade.");
    }

    // Create and add drink to order
    Drink drink = new Drink(size, flavor);
    currentOrder.getDrinks().add(drink);

    // Display drink and cost
    UIHelper.divider();
    UIHelper.typeText("Drink added: " + drink,20);
    UIHelper.typeText("Price: $" + drink.getPrice(),20);

    }

    // Method to add chips
    public void addChips(){

        // Ask user if they want to add chips
        UIHelper.heading("Add chips to your order");

        // Display the menu using stream
        UIHelper.divider();
        Chip.MENU.stream()
                .map(chip -> (Chip.MENU.indexOf(chip) + 1) + ") " + chip)
                .forEach(System.out::println);
        System.out.println("0) Cancel");

        // Ask user to pick a chip
        int chipChoice = InputHelper.getInt(UIHelper.YELLOW + "Enter chip number: " + UIHelper.RESET);

        // Cancel if user enters 0
        if (chipChoice == 0) {
            UIHelper.warning("Chip selection cancelled.");
            return;
        }

        // Validate choice and get chip choice
        String chipType = (chipChoice >= 1 && chipChoice <= Chip.MENU.size())
                // If the input is valid subtract 1 otherwise default to lemonade
                ? Chip.MENU.get(chipChoice - 1) : null;

        // If the input is invalid it prints out this message
        if (chipType == null) {
            UIHelper.warning("Invalid choice. No chips added");
        }

        // Create and add chips to order
        Chip chips = new Chip(chipType);
        currentOrder.getChips().add(chips);

        // Display drink and cost
        UIHelper.divider();
        UIHelper.typeText("Chips added: " + chips, 20);
        UIHelper.typeText("Price: $" + chips.getPrice(), 20);
    }

    //Method to check out
    public void checkout() {
        UIHelper.heading("Final Order Summary:");

        UIHelper.typeText(currentOrder.summary(), 15);

        UIHelper.divider();

        // Save to file
        UIHelper.showSpinner(2);
        ReceiptWriter.write(currentOrder);

        // Print order complete
        UIHelper.success("Order complete.");
    }


}

package com.LeafandLoaf.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    // Properties of an order
    private int id;
    private LocalDate date;
    private LocalTime time;

    // List to hold the different parts of the order
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();

    // Constructor
    public Order(int id, LocalDate date, LocalTime time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void setChips(List<Chip> chips) {
        this.chips = chips;
    }

    // Method to get total price of the entire order
    public double getTotal() {
        // Total starts at zero
        double total = 0.0;

        // Loops through each Sandwich, calls its
        // calculatePrice() method, and adds the sandwiches price to total
        for (Sandwich s : sandwiches) {
            total += s.calculatePrice();
        }

        // Loops through each Drink, calls its
        // calculatePrice() method, and adds the drinks price to total
        for (Drink d : drinks) {
            total += d.getPrice();
        }

        // Loops through each Chip, calls its
        // calculatePrice() method, and adds the chips price to total
        for (Chip c : chips) {
            total += c.getPrice();
        }
        // Returns the total
        return total;
    }

    // Method to return order summary
    public String summary(){



        // String builder to hold receipt
        StringBuilder order = new StringBuilder();
        order.append("Order Summary: \n");

        // Loops through each sandwich and prints out the formated line
        for (Sandwich s : sandwiches) {
            order.append("- Sandwich: ").append(s.toString()).append("\n");
        }

        // Loops through each drink and prints out the formated line
        for (Drink d : drinks) {
            order.append("- Drink: ").append(d.toString()).append("\n");
        }

        // Loops through each sandwich and prints out the formated line
        for (Chip c : chips) {
            order.append("- Chip: ").append(c.toString()).append("\n");
        }

        // Prints out the total cost
        order.append("Total: $").append(getTotal());

        // returns the order as a string
        return order.toString();
    }

    @Override
    public String toString() {
        return summary();
    }


}

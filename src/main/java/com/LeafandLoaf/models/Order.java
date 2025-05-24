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

    // Method to get total price of the entire order
    public double getTotal() {
        double total = 0.0;

        // Add sandwich prices
        for (Sandwich s : sandwiches) {
            total += s.calculatePrice();
        }

        // Add drink prices
        for (Drink d : drinks) {
            total += d.getPrice();
        }

        // Add chip prices
        for (Chip c : chips) {
            total += c.getPrice();
        }
        return total;
    }

    // Method to return order summary
    public String summary(){

        StringBuilder order = new StringBuilder();
        order.append("Order Summary: \n");

        for (Sandwich s : sandwiches) {
            order.append("- Sandwich: ").append(s.toString()).append("\n");
        }

        for (Drink d : drinks) {
            order.append("- Drink: ").append(d.toString()).append("\n");
        }

        for (Chip c : chips) {
            order.append("- Chip: ").append(c.toString()).append("\n");
        }
        order.append("Total: $").append(getTotal());

        return order.toString();
    }


}

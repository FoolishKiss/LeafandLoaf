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


}

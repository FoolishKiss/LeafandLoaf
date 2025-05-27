package com.LeafandLoaf.models;

import java.util.List;

public class Chip {

    private String type;
    private final double price = 1.50;

    public Chip(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public static final List<String> MENU = List.of("BBQ", "Sea Salt", "Sour Cream & Onion",
            "Salt & Vinegar", "Jalapeno");

    @Override
    public String toString() {
        return type + " Chips";
    }
}

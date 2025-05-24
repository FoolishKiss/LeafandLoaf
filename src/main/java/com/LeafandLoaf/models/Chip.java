package com.LeafandLoaf.models;

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

    @Override
    public String toString() {
        return type + " Chips";
    }
}

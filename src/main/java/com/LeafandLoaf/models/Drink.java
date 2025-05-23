package com.LeafandLoaf.models;

public class Drink {

    private String size = DrinkSize;
    private String flavor;
    private double price;


    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }
}

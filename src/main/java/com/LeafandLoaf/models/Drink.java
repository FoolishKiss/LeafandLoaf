package com.LeafandLoaf.models;

import com.LeafandLoaf.models.enums.DrinkSize;

public class Drink {

    private String DrinkSize;
    private String flavor;
    private double price;


    public Drink(double price, String flavor, String drinkSize) {
        this.price = price;
        this.flavor = flavor;
        DrinkSize = drinkSize;
    }

    public String getDrinkSize() {
        return DrinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        DrinkSize = drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

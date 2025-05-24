package com.LeafandLoaf.models;

import com.LeafandLoaf.models.enums.DrinkSize;

public class Drink {

    // Properties of a drink order
    private DrinkSize drinkSize;
    private String flavor;


    // Constructor
    public Drink(DrinkSize drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }

    // Getters and setters
    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }


    // Method to get price of drink based on size
    public double getPrice() {
        switch (drinkSize) {
            case SMALL: return 2.00;
            case MEDIUM: return 2.50;
            case LARGE: return 3.00;
            default: return 0.0;
        }
    }

    // To format the drink order
    @Override
    public String toString() {
        return drinkSize + " " + flavor;
    }

}

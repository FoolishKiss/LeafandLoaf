package com.LeafandLoaf.models;

import com.LeafandLoaf.models.enums.BreadType;
import com.LeafandLoaf.models.enums.Size;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    // Properties of a sandwich
    protected Size size;
    protected BreadType bread;
    protected boolean toasted;
    protected List<Topping> toppings;

    // Constructor
    public Sandwich(Size size, BreadType bread, boolean toasted, List<Topping> toppings) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BreadType getBread() {
        return bread;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }



    // Method to calculate sandwich price
    public double calculatePrice() {
        double basePrice = 0.0;

        // Determine base price based on size
        switch (size) {
            case FOUR: basePrice = 5.50; break;
            case EIGHT: basePrice = 7.00; break;
            case TWELVE: basePrice = 8.50; break;
        }



        // Loops through toppings price and adds to base price
        for (Topping t: toppings) {
            double toppingPrice = t.getPrice(size);
            basePrice += t.getPrice(size);
        }

        // Returns final price of sandwich with toppings
        return basePrice;
    }

    //Method to get label of size by converting the values into string
    public String getSizeLabel() {
        switch (size) {
            case FOUR: return "4 inch";
            case EIGHT: return "8 inch";
            case TWELVE: return "12 inch";
            default: return "";
        }
    }

    // Format the sandwich is printed in
    @Override
    public String toString() {
        return getSizeLabel() + " on " + bread + " sandwich" + (toasted ? " (toasted)" : "");
    }


}

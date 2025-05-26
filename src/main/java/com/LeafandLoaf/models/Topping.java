package com.LeafandLoaf.models;

import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;

import java.util.List;

import static com.LeafandLoaf.models.enums.ToppingType.CHEESE;

public class Topping {

    // Properties for toppings
    private String name;
    private ToppingType type;
    private boolean isExtra;

    // Constructor
    public Topping(String name, ToppingType type, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public static final List<Topping> MENU = List.of(
            new Topping("Tofu Ham", ToppingType.ALTMEAT,false),
            new Topping("Roasted chickpeas", ToppingType.ALTMEAT,false),
            new Topping("Vegan Turkey", ToppingType.ALTMEAT,true),
            new Topping("Tofu Strips", ToppingType.ALTMEAT,true),
            new Topping("Vegan Bacon", ToppingType.ALTMEAT,true),
            new Topping("Lettuce", ToppingType.REGULAR,false),
            new Topping("Jalapenos", ToppingType.REGULAR,false),
            new Topping("Tomato", ToppingType.REGULAR,false),
            new Topping("Cucumber", ToppingType.REGULAR,false),
            new Topping("Bell peppers", ToppingType.REGULAR,false),
            new Topping("Mushrooms", ToppingType.REGULAR,false),
            new Topping("Mustard", ToppingType.SAUCE,false),
            new Topping("Mayo", ToppingType.SAUCE,false),
            new Topping("Pepper Jack", ToppingType.CHEESE,false),
            new Topping("Cheddar", ToppingType.CHEESE,false)
    );

    // Method to get price
    public double getPrice(Size size) {

        //Initialize price at 0
        double price = 0.0;

        // Price of premium meat
        if (type == ToppingType.ALTMEAT) {
            switch (size) {
                case FOUR: price = 1.00; break;
                case EIGHT: price = 2.00; break;
                case TWELVE: price = 3.00; break;
            }
            if (isExtra) {
                switch (size) {
                    case FOUR: price += 0.50; break;
                    case EIGHT: price += 1.00; break;
                    case TWELVE: price += 1.50; break;
                }
            }
        }

        // Price of premium cheese
        else if (type == CHEESE) {
            switch (size) {
                case FOUR: price = 0.75; break;
                case EIGHT: price = 1.50; break;
                case TWELVE: price = 2.25; break;
            }
            if (isExtra) {
                switch (size) {
                    case FOUR: price += 0.30; break;
                    case EIGHT: price += 0.60; break;
                    case TWELVE: price += 0.90; break;
                }
            }
        }

        return price;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }


}
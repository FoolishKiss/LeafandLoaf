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

    //Constructor
    public Sandwich(Size size, BreadType bread, boolean toasted, List<Topping> toppings) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }
}

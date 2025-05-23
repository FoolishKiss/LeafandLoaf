package com.LeafandLoaf.models;

import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;

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







}

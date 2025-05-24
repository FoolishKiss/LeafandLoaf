package com.LeafandLoaf.ui;

import com.LeafandLoaf.models.Sandwich;
import com.LeafandLoaf.models.Topping;
import com.LeafandLoaf.models.enums.BreadType;
import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;

import java.util.Arrays;

public class ModelTester {
    public static void main(String[] args) {

        //Create toppings
        Topping veganBacon = new Topping("Vegan Bacon", ToppingType.ALTMEAT, false);
        Topping cheddar = new Topping("Cheddar", ToppingType.CHEESE, true);
        Topping jalapenos = new Topping("Jalapenos", ToppingType.REGULAR, false);


        //Create sandwich
        Sandwich mySandwich = new Sandwich(Size.EIGHT,
                BreadType.WHEAT,
                true,
                Arrays.asList(veganBacon, cheddar, jalapenos)
        );


        //Calculate price
        System.out.println(mySandwich);
        System.out.println("Price: " + mySandwich.calculatePrice());

        // View topping costs
        System.out.println("Vegan Bacon price: $" + veganBacon.getPrice(Size.EIGHT));
        System.out.println("Cheddar (extra) price: $" + cheddar.getPrice(Size.EIGHT));
    }

}

package com.LeafandLoaf.ui;

import com.LeafandLoaf.models.*;
import com.LeafandLoaf.models.enums.BreadType;
import com.LeafandLoaf.models.enums.DrinkSize;
import com.LeafandLoaf.models.enums.Size;
import com.LeafandLoaf.models.enums.ToppingType;

import java.time.LocalDate;
import java.time.LocalTime;
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

        // Create drink
        Drink lemonade = new Drink(DrinkSize.MEDIUM, "Lemonade");

        // Create chips
        Chip bbqChips = new Chip("BBQ");

        // Create order
        Order order = new Order(1, LocalDate.now(), LocalTime.now());

        // Add items to order
        order.getSandwiches().add(mySandwich);
        order.getDrinks().add(lemonade);
        order.getChips().add(bbqChips);

        // Printout the receipt
        System.out.println(order.summary());


    }

}

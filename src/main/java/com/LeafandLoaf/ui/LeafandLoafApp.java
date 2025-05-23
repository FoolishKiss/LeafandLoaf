package com.LeafandLoaf.ui;

import com.LeafandLoaf.data.OrderDataManager;

public class LeafandLoafApp {
    public static void main(String[] args) {

        // Creates a new order manager
        OrderDataManager manager = new OrderDataManager();
        // Starts the order by calling the managers startOrder method
        manager.startOrder();

    }
}

package com.techelevator.view;

import com.techelevator.inventory;

public class Drink extends inventory {

    public Drink(String name, String cost, int inventory) {
        super (name, cost, inventory);

    }

    public String getSound () {
        System.out.println("Glug Glug, Yum!");
        return "Glug Glug, Yum!";
    }
}


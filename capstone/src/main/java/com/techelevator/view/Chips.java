package com.techelevator.view;

import com.techelevator.inventory;

public  class Chips extends inventory {

    public Chips (String name, String cost, int inventory) {
        super (name, cost, inventory);

    }

    public String getSound () {
        System.out.println("Crunch Crunch, Yum!");
        return "Crunch Crunch, Yum!";
    }
}
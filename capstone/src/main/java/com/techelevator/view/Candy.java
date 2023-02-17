package com.techelevator.view;

import com.techelevator.inventory;

public class Candy extends inventory {

    public Candy(String name, String cost, int inventory) {
        super (name, cost, inventory);

    }

    public String getSound () {
        System.out.println("Munch Munch, Yum!");
        return "Munch Munch, Yum!";
    }
}
